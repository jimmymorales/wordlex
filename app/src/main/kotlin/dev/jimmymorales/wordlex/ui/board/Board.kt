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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                WordleChar.Invalid('B'),
                WordleChar.Invalid('O'),
                WordleChar.ExactMatch('A'),
                WordleChar.Invalid('T'),
                WordleChar.CloseMatch('S')
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
    val color = when (char) {
        is WordleChar.Empty -> colorScheme.surface
        is WordleChar.CloseMatch -> colorScheme.tertiaryContainer
        is WordleChar.ExactMatch -> colorScheme.secondaryContainer
        is WordleChar.Invalid -> colorScheme.inverseSurface
    }
    Surface(
        modifier = modifier
            .padding(2.dp)
            .size(48.dp),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.surfaceVariant,
        ).takeIf { char is WordleChar.Empty },
        color = color,
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

    data class ExactMatch(override val value: Char) : WordleChar()
    data class CloseMatch(override val value: Char) : WordleChar()
    data class Invalid(override val value: Char) : WordleChar()
    object Empty : WordleChar() {
        override val value: Char = ' '
    }
}
