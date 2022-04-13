package dev.jimmymorales.wordlex.ui.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jimmymorales.wordlex.ui.model.BoardState

@Composable
fun Board(
    board: BoardState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        WordRow(word = board.word1)
        WordRow(word = board.word2)
        WordRow(word = board.word3)
        WordRow(word = board.word4)
        WordRow(word = board.word5)
        WordRow(word = board.word6)
    }
}

