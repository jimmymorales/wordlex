package dev.jimmymorales.wordlex.features.board.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.model.WordTile
import dev.jimmymorales.wordlex.model.WordleChar
import dev.jimmymorales.wordlex.model.label
import dev.jimmymorales.wordlex.theme.WordleXTheme
import dev.jimmymorales.wordlex.utils.backgroundColor
import dev.jimmymorales.wordlex.utils.contentColor

@Composable
fun BoardTile(
    char: WordTile,
    modifier: Modifier = Modifier,
) {
    val colorScheme = MaterialTheme.colorScheme
    val backgroundColor = when (char) {
        is WordTile.Editing,
        is WordTile.Empty -> colorScheme.surface
        is WordTile.Filled -> char.value.status.backgroundColor
    }
    val contentColor = when (char) {
        is WordTile.Editing,
        is WordTile.Empty -> contentColorFor(backgroundColor)
        is WordTile.Filled -> char.value.status.contentColor
    }
    val borderColor = when (char) {
        is WordTile.Editing -> colorScheme.outline
        is WordTile.Empty -> colorScheme.surfaceVariant
        is WordTile.Filled -> null
    }
    Surface(
        modifier = modifier
            .padding(2.dp)
            .size(56.dp),
        border = borderColor?.let { color -> BorderStroke(width = 2.dp, color = color) },
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = if (char is WordTile.Filled && char.value.status == CharStatus.Invalid) {
            2.dp
        } else {
            0.dp
        },
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = char.value.label,
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}

internal class WordTilePreviewParameterProvider : CollectionPreviewParameterProvider<WordTile>(
    listOf(
        WordTile.Filled(WordleChar.A(status = CharStatus.ExactMatch)),
        WordTile.Filled(WordleChar.S(status = CharStatus.CloseMatch)),
        WordTile.Filled(WordleChar.D(status = CharStatus.Invalid)),
        WordTile.Filled(WordleChar.F(status = CharStatus.Available)),
        WordTile.Editing(WordleChar.G()),
        WordTile.Empty,
    )
)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardTilePreview(
    @PreviewParameter(WordTilePreviewParameterProvider::class) tile: WordTile,
) {
    WordleXTheme {
        Surface {
            BoardTile(char = tile)
        }
    }
}
