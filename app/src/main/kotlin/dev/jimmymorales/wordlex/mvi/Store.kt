package dev.jimmymorales.wordlex.mvi

import kotlinx.coroutines.flow.StateFlow

interface ViewState
interface ViewIntent
interface ReduceAction

/**
 * A [ViewState] is used to manage [ViewState] and dispatch [ReduceAction]s that can update the state.
 */
interface Store<S : ViewState, I : ViewIntent, A : ReduceAction> {

    val state: StateFlow<S>

    fun onIntent(intent: I)
}
