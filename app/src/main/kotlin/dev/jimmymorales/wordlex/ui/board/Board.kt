package dev.jimmymorales.wordlex.ui.board

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jimmymorales.wordlex.ui.model.BoardState
import dev.jimmymorales.wordlex.ui.model.CharStatus
import dev.jimmymorales.wordlex.ui.model.Word
import dev.jimmymorales.wordlex.ui.model.WordTile
import dev.jimmymorales.wordlex.ui.model.WordleChar
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme

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

internal val mockBoard = BoardState(
    word1 = Word(
        WordTile.Filled(value = WordleChar.R, status = CharStatus.ExactMatch),
        WordTile.Filled(value = WordleChar.A, status = CharStatus.CloseMatch),
        WordTile.Filled(value = WordleChar.D, status = CharStatus.Invalid),
        WordTile.Filled(value = WordleChar.I, status = CharStatus.Invalid),
        WordTile.Filled(value = WordleChar.O, status = CharStatus.CloseMatch),
    ),
    word2 = Word(
        WordTile.Editing(value = WordleChar.R),
        WordTile.Empty,
        WordTile.Empty,
        WordTile.Empty,
        WordTile.Empty,
    ),
)

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

