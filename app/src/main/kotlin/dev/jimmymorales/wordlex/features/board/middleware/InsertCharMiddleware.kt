package dev.jimmymorales.wordlex.features.board.middleware

import dev.jimmymorales.wordlex.features.board.GameIntent
import dev.jimmymorales.wordlex.features.board.GameReduceAction
import dev.jimmymorales.wordlex.features.board.GameState
import dev.jimmymorales.wordlex.model.WordleChar
import dev.jimmymorales.wordlex.model.append
import dev.jimmymorales.wordlex.model.currentWordIndex
import dev.jimmymorales.wordlex.model.get
import dev.jimmymorales.wordlex.mvi.Middleware

class InsertCharMiddleware : Middleware<GameState, GameIntent, GameReduceAction> {
    override suspend fun process(
        intent: GameIntent,
        currentState: () -> GameState,
        dispatch: suspend (GameReduceAction) -> Unit
    ) {
        when (intent) {
            is GameIntent.KeyPressed -> {
                val char = intent.key as? WordleChar ?: return
                val currentWordIndex = currentState().board.currentWordIndex
                val currentWord = currentState().board[currentWordIndex] ?: return
                dispatch(GameReduceAction.UpdateWord(currentWordIndex, currentWord.append(char)))
            }
        }
    }
}
