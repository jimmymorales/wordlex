package dev.jimmymorales.wordlex.ui.board

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import dev.jimmymorales.wordlex.ui.model.CharStatus
import dev.jimmymorales.wordlex.ui.model.Word
import dev.jimmymorales.wordlex.ui.model.WordTile
import dev.jimmymorales.wordlex.ui.model.WordleChar
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme

@Composable
fun WordRow(
    word: Word,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        BoardTile(char = word.char1)
        BoardTile(char = word.char2)
        BoardTile(char = word.char3)
        BoardTile(char = word.char4)
        BoardTile(char = word.char5)
    }
}

internal class WordPreviewParameterProvider : CollectionPreviewParameterProvider<Word>(
    listOf(
        Word(
            WordTile.Filled(value = WordleChar.R, status = CharStatus.ExactMatch),
            WordTile.Filled(value = WordleChar.A, status = CharStatus.CloseMatch),
            WordTile.Filled(value = WordleChar.D, status = CharStatus.Invalid),
            WordTile.Filled(value = WordleChar.I, status = CharStatus.Invalid),
            WordTile.Filled(value = WordleChar.O, status = CharStatus.CloseMatch),
        ),
        Word(
            WordTile.Editing(value = WordleChar.R),
        ),
        Word(),
    )
)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun WordRowPreview(
    @PreviewParameter(WordPreviewParameterProvider::class) word: Word,
) {
    WordleXTheme {
        Surface {
            WordRow(word)
        }
    }
}
