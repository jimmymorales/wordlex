package dev.jimmymorales.wordlex.ui.board

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
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.ui.model.CharStatus
import dev.jimmymorales.wordlex.ui.model.WordTile
import dev.jimmymorales.wordlex.ui.model.WordleChar
import dev.jimmymorales.wordlex.ui.utils.backgroundColor
import dev.jimmymorales.wordlex.ui.utils.contentColor

@Composable
fun BoardTile(
    char: WordTile,
    modifier: Modifier = Modifier,
) {
    val colorScheme = MaterialTheme.colorScheme
    val backgroundColor = when (char) {
        is WordTile.Editing,
        is WordTile.Empty -> colorScheme.surface
        is WordTile.Filled -> char.status.backgroundColor
    }
    val contentColor = when (char) {
        is WordTile.Editing,
        is WordTile.Empty -> contentColorFor(backgroundColor)
        is WordTile.Filled -> char.status.contentColor
    }
    val borderColor = when (char) {
        is WordTile.Editing -> colorScheme.outline
        is WordTile.Empty -> colorScheme.surfaceVariant
        is WordTile.Filled -> null
    }
    Surface(
        modifier = modifier
            .padding(2.dp)
            .size(48.dp),
        border = borderColor?.let { color -> BorderStroke(width = 2.dp, color = color) },
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = if (char is WordTile.Filled && char.status == CharStatus.Invalid) {
            2.dp
        } else {
            0.dp
        },
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = char.value.asText(),
                fontStyle = MaterialTheme.typography.displayLarge.fontStyle,
            )
        }
    }
}

private fun WordleChar.asText(): String = if (this == WordleChar.Empty) "" else this.toString()