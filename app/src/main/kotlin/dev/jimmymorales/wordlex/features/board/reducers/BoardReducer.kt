package dev.jimmymorales.wordlex.features.board.reducers

import dev.jimmymorales.wordlex.features.board.GameReduceAction
import dev.jimmymorales.wordlex.features.board.GameState
import dev.jimmymorales.wordlex.model.update
import dev.jimmymorales.wordlex.mvi.Reducer

val boardReducer = Reducer<GameState, GameReduceAction> { state, action ->
    when (action) {
        is GameReduceAction.UpdateWord -> state.copy(
            board = state.board.update(action.index, action.word)
        )
    }
}
