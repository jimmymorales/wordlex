package dev.jimmymorales.wordlex.features.board

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jimmymorales.wordlex.model.BoardState
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.model.KeyboardItem
import dev.jimmymorales.wordlex.model.KeyboardState
import dev.jimmymorales.wordlex.model.Word
import dev.jimmymorales.wordlex.model.WordTile
import dev.jimmymorales.wordlex.model.WordleChar
import dev.jimmymorales.wordlex.mvi.MviStore
import dev.jimmymorales.wordlex.mvi.ReduceAction
import dev.jimmymorales.wordlex.mvi.Store
import dev.jimmymorales.wordlex.mvi.ViewIntent
import dev.jimmymorales.wordlex.mvi.ViewState

class BoardViewModel : ViewModel(), Store<GameState, BoardIntent, BoardReduceAction> {
    private val store = MviStore<GameState, BoardIntent, BoardReduceAction>(
        initialState = mockGame,
        scope = viewModelScope,
        /*middlewares = listOf(
            Middleware { intent, currentState, dispatch ->
                when (intent) {
                    is BoardIntent.KeyPressed -> when (val key = intent.key) {
                        is KeyboardItem.Enter -> TODO()
                        is KeyboardItem.Backspace -> TODO()
                        else -> dispatch(BoardReduceAction.EditTile(key as WordleChar))
                    }
                }
            }
        ),
        reducer = Reducer { currentState, action ->
            when (action) {
                is BoardReduceAction.EditTile -> {
                    val currentWord = when (currentState.board.currentWordNumber) {
                        WordNumber.One -> currentState.board.word1
                        WordNumber.Two -> currentState.board.word2
                        WordNumber.Three -> currentState.board.word3
                        WordNumber.Four -> currentState.board.word4
                        WordNumber.Five -> currentState.board.word5
                        WordNumber.Six -> currentState.board.word6
                        WordNumber.None -> TODO()
                    }

                }
            }
        }*/
    )
    override val state = store.state

    override fun onIntent(intent: BoardIntent) {
        store.onIntent(intent)
    }
}

data class GameState(
    val board: BoardState = BoardState(),
    val keyboard: KeyboardState = KeyboardState(),
) : ViewState

sealed interface BoardIntent : ViewIntent {
    data class KeyPressed(val key: KeyboardItem) : BoardIntent
}

sealed interface BoardReduceAction : ReduceAction {
    data class EditTile(val key: WordleChar) : BoardReduceAction
}

internal val mockBoard = BoardState(
    word1 = Word(
        WordTile.Filled(value = WordleChar.A(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.U(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.D(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.I(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.O(status = CharStatus.Invalid)),
    ),
    word2 = Word(
        WordTile.Filled(value = WordleChar.M(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.E(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.A(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.N(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.T(status = CharStatus.Invalid)),
    ),
    word3 = Word(
        WordTile.Filled(value = WordleChar.G(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.A(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.M(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.E(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.S(status = CharStatus.Invalid)),
    ),
    word4 = Word(
        WordTile.Filled(value = WordleChar.G(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.A(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.M(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.E(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.R(status = CharStatus.ExactMatch)),
    ),
)

internal val mockKeyboard = KeyboardState(
    a = WordleChar.A(status = CharStatus.CloseMatch),
    d = WordleChar.D(status = CharStatus.Invalid),
    i = WordleChar.I(status = CharStatus.Invalid),
    o = WordleChar.O(status = CharStatus.CloseMatch),
    r = WordleChar.R(status = CharStatus.ExactMatch),
)

private val mockGame = GameState(
    board = mockBoard,
    keyboard = mockKeyboard,
)
