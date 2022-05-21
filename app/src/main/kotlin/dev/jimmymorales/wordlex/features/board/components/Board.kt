package dev.jimmymorales.wordlex.features.board.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jimmymorales.wordlex.features.board.mockBoard
import dev.jimmymorales.wordlex.model.BoardState
import dev.jimmymorales.wordlex.theme.WordleXTheme

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

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardPreview() {
    WordleXTheme {
        Surface {
            Board(mockBoard)
        }
    }
}

