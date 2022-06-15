package dev.jimmymorales.wordlex.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch

/**
 * A [MviStore] is a base implementation of a [Store] that handles managing state and dispatching
 * actions through the appropriate [middlewares] and [reducer].
 *
 * @param[initialState] This is the initial state of the screen when it is first created.
 * @param[reducer] A system for taking in the current state, and a new action, and outputting the
 * updated state.
 * @param[middlewares] This is a list of [Middleware] entities for handling any side effects
 * for actions dispatched to this store.
 */
class MviStore<S : ViewState, I : ViewIntent, A : ReduceAction>(
    initialState: S,
    scope: CoroutineScope = CoroutineScope(SupervisorJob()),
    private val reducer: Reducer<S, A> = Reducer { currentState, _ -> currentState },
    private val middlewares: List<Middleware<S, I, A>> = emptyList()
) : Store<S, I, A> {

    private val internalState = MutableStateFlow(initialState)
    override val state: StateFlow<S> = internalState.asStateFlow()

    private val intents = MutableSharedFlow<I>(extraBufferCapacity = 64)
    private val actions = MutableSharedFlow<A>(extraBufferCapacity = 64)

    init {
        intents
            .onEach { intent ->
                middlewares.forEach { middleware ->
                    scope.launch {
                        middleware.process(intent, internalState::value, actions::emit)
                    }
                }
            }
            .launchIn(scope)

        actions
            .scan(initialState, reducer::reduce)
            .onEach { newState ->
                internalState.value = newState
            }
            .launchIn(scope)
    }

    override fun onIntent(intent: I) {
        intents.tryEmit(intent)
    }
}
