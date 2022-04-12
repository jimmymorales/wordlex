package dev.jimmymorales.wordlex.ui.board

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.ui.keyboard.CharStatus
import dev.jimmymorales.wordlex.ui.theme.LocalExtendedColors

@Composable
fun Board(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        WordRow(
            listOf(
                WordleChar.Filled(value = 'R', status = CharStatus.ExactMatch),
                WordleChar.Filled(value = 'A', status = CharStatus.CloseMatch),
                WordleChar.Filled(value = 'D', status = CharStatus.Invalid),
                WordleChar.Filled(value = 'I', status = CharStatus.Invalid),
                WordleChar.Filled(value = 'O', status = CharStatus.CloseMatch),
            )
        )
        WordRow(
            listOf(
                WordleChar.Editing(value = 'R'),
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty
            )
        )
        WordRow(
            listOf(
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty
            )
        )
        WordRow(
            listOf(
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty
            )
        )
        WordRow(
            listOf(
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty
            )
        )
        WordRow(
            listOf(
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty,
                WordleChar.Empty
            )
        )
    }
}

@Composable
fun WordRow(
    word: List<WordleChar>,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        word.forEach { char ->
            BoardTile(char = char)
        }
    }
}

@Composable
fun BoardTile(
    char: WordleChar,
    modifier: Modifier = Modifier,
) {
    val colorScheme = MaterialTheme.colorScheme
    val backgroundColor = when (char) {
        is WordleChar.Editing,
        is WordleChar.Empty -> colorScheme.surface
        is WordleChar.Filled -> char.status.backgroundColor
    }
    val contentColor = when (char) {
        is WordleChar.Editing,
        is WordleChar.Empty -> contentColorFor(backgroundColor)
        is WordleChar.Filled -> char.status.contentColor
    }
    val borderColor = when (char) {
        is WordleChar.Editing -> colorScheme.outline
        is WordleChar.Empty -> colorScheme.surfaceVariant
        is WordleChar.Filled -> null
    }
    Surface(
        modifier = modifier
            .padding(2.dp)
            .size(48.dp),
        border = borderColor?.let { color -> BorderStroke(width = 2.dp, color = color) },
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = if (char is WordleChar.Filled && char.status == CharStatus.Invalid) {
            2.dp
        } else {
            0.dp
        },
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = char.value.toString(),
                fontStyle = MaterialTheme.typography.displayLarge.fontStyle,
            )
        }
    }
}

sealed class WordleChar {
    abstract val value: Char

    data class Filled(override val value: Char, val status: CharStatus) : WordleChar()
    data class Editing(override val value: Char) : WordleChar()
    object Empty : WordleChar() {
        override val value: Char = ' '
    }
}

internal val CharStatus.backgroundColor: Color
    @ReadOnlyComposable
    @Composable
    get() {
        val colorScheme = MaterialTheme.colorScheme
        val extendedColors = LocalExtendedColors.current
        return when (this) {
            CharStatus.ExactMatch -> Color(extendedColors.exactMatch.roles.accentContainer)
            CharStatus.CloseMatch -> Color(extendedColors.closeMatch.roles.accentContainer)
            CharStatus.Invalid,
            CharStatus.Available -> colorScheme.surface
        }
    }

internal val CharStatus.contentColor: Color
    @ReadOnlyComposable
    @Composable
    get() {
        val extendedColors = LocalExtendedColors.current
        return when (this) {
            CharStatus.ExactMatch -> Color(extendedColors.exactMatch.roles.onAccentContainer)
            CharStatus.CloseMatch -> Color(extendedColors.closeMatch.roles.onAccentContainer)
            CharStatus.Invalid,
            CharStatus.Available -> contentColorFor(backgroundColor = backgroundColor)
        }
    }
