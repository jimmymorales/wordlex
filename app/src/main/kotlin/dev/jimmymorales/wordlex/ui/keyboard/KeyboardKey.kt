package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme
import dev.jimmymorales.wordlex.ui.utils.backgroundColor
import dev.jimmymorales.wordlex.ui.utils.contentColor

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
        modifier = modifier,
        tonalElevation = if (item is KeyboardItem.KeyChar && item.status == CharStatus.Invalid) {
            2.dp
        } else {
            16.dp
        },
        color = backgroundColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(4.dp),
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .defaultMinSize(minWidth = 28.dp, minHeight = 56.dp)
                .clickable {
                    TODO("Select Key")
                }
                .padding(4.dp),
            contentAlignment = Alignment.Center,
        ) {
            when (item) {
                is KeyboardItem.Enter -> Text(
                    text = "ENTER",
                    style = MaterialTheme.typography.bodySmall,
                )
                is KeyboardItem.KeyChar -> Text(
                    text = item.value.toString(),
                    style = MaterialTheme.typography.bodySmall,
                )
                is KeyboardItem.Icon -> Icon(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(20.dp),
                    imageVector = item.value,
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview
@Composable
private fun KeyPreview() {
    WordleXTheme {
        KeyboardKey(KeyboardItem.KeyChar(value = WordleChar.W, status = CharStatus.ExactMatch))
    }
}
