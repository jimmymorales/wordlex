package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.ui.model.CharStatus
import dev.jimmymorales.wordlex.ui.model.KeyboardItem
import dev.jimmymorales.wordlex.ui.model.WordleChar
import dev.jimmymorales.wordlex.ui.utils.backgroundColor
import dev.jimmymorales.wordlex.ui.utils.contentColor
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme

@Composable
fun KeyboardKey(
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

@Preview
@Composable
fun KeyPreview() {
    WordleXTheme {
        KeyboardKey(KeyboardItem.KeyChar(value = WordleChar.W, status = CharStatus.ExactMatch))
    }
}