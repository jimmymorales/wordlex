package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.ui.board.backgroundColor
import dev.jimmymorales.wordlex.ui.board.contentColor
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme
import dev.jimmymorales.wordlex.ui.theme.icons.Backspace

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KeyboardRow(
            keys = listOf(
                KeyboardItem.KeyChar('Q'),
                KeyboardItem.KeyChar('W'),
                KeyboardItem.KeyChar('E'),
                KeyboardItem.KeyChar('R', status = CharStatus.ExactMatch),
                KeyboardItem.KeyChar('T'),
                KeyboardItem.KeyChar('Y'),
                KeyboardItem.KeyChar('U'),
                KeyboardItem.KeyChar('I', status = CharStatus.Invalid),
                KeyboardItem.KeyChar('O', status = CharStatus.CloseMatch),
                KeyboardItem.KeyChar('P')
            )
        )
        KeyboardRow(
            keys = listOf(
                KeyboardItem.KeyChar('A', status = CharStatus.CloseMatch),
                KeyboardItem.KeyChar('S'),
                KeyboardItem.KeyChar('D', status = CharStatus.Invalid),
                KeyboardItem.KeyChar('F'),
                KeyboardItem.KeyChar('G'),
                KeyboardItem.KeyChar('H'),
                KeyboardItem.KeyChar('J'),
                KeyboardItem.KeyChar('K'),
                KeyboardItem.KeyChar('L')
            )
        )
        KeyboardRow(
            keys = listOf(
                KeyboardItem.Enter,
                KeyboardItem.KeyChar('Z'),
                KeyboardItem.KeyChar('X'),
                KeyboardItem.KeyChar('C'),
                KeyboardItem.KeyChar('V'),
                KeyboardItem.KeyChar('B'),
                KeyboardItem.KeyChar('N'),
                KeyboardItem.KeyChar('M'),
                KeyboardItem.Icon(Icons.Filled.Backspace)
            )
        )
    }
}

@Composable
fun KeyboardRow(
    keys: List<KeyboardItem>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
    ) {
        keys.forEach { key ->
            Key(item = key)
        }
    }
}

@Composable
fun Key(
    item: KeyboardItem,
    modifier: Modifier = Modifier,
) {
    val colorScheme = MaterialTheme.colorScheme
    val backgroundColor = when (item) {
        is KeyboardItem.Enter,
        is KeyboardItem.Icon -> colorScheme.surface
        is KeyboardItem.KeyChar -> item.status.backgroundColor
    }
    val contentColor = when (item) {
        is KeyboardItem.Enter,
        is KeyboardItem.Icon -> contentColorFor(backgroundColor)
        is KeyboardItem.KeyChar -> item.status.contentColor
    }
    Surface(
        modifier = modifier
            .padding(4.dp),
        tonalElevation = if (item is KeyboardItem.KeyChar && item.status == CharStatus.Invalid) {
            2.dp
        } else {
            16.dp
        },
        color = backgroundColor,
        contentColor = contentColor,
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .defaultMinSize(minWidth = 32.dp, minHeight = 32.dp)
                .clickable {
                    // TODO: Select Key
                }
                .padding(4.dp),
            contentAlignment = Alignment.Center,
        ) {
            when (item) {
                is KeyboardItem.Enter -> Text(
                    text = "ENTER",
                )
                is KeyboardItem.KeyChar -> Text(
                    text = item.value.toString(),
                )
                is KeyboardItem.Icon -> Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = item.value,
                    contentDescription = null,
                )
            }
        }
    }
}

sealed interface KeyboardItem {
    data class KeyChar(
        val value: Char,
        val status: CharStatus = CharStatus.Available,
    ) : KeyboardItem

    data class Icon(val value: ImageVector) : KeyboardItem
    object Enter : KeyboardItem
}

enum class CharStatus {
    ExactMatch, CloseMatch, Invalid, Available,
}

@Preview
@Composable
fun KeyPreview() {
    WordleXTheme {
        Key(KeyboardItem.KeyChar(value = 'Q', status = CharStatus.ExactMatch))
    }
}
