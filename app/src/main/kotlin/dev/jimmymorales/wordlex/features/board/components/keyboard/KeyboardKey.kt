package dev.jimmymorales.wordlex.features.board.components.keyboard

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.model.KeyboardItem
import dev.jimmymorales.wordlex.model.WordleChar
import dev.jimmymorales.wordlex.model.label
import dev.jimmymorales.wordlex.theme.WordleXTheme
import dev.jimmymorales.wordlex.utils.backgroundColor
import dev.jimmymorales.wordlex.utils.contentColor

@Composable
fun KeyboardKey(
    item: KeyboardItem,
    modifier: Modifier = Modifier,
    onKeyPressed: (KeyboardItem) -> Unit = {},
) {
    val colorScheme = MaterialTheme.colorScheme
    val backgroundColor = if (item is WordleChar) {
        item.status.backgroundColor
    } else {
        colorScheme.surface
    }
    val contentColor = if (item is WordleChar) {
        item.status.contentColor
    } else {
        contentColorFor(backgroundColor)
    }
    Surface(
        modifier = modifier,
        tonalElevation = if (item is WordleChar && item.status == CharStatus.Invalid) {
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
                .clickable { onKeyPressed(item) }
                .padding(4.dp),
            contentAlignment = Alignment.Center,
        ) {
            when (item) {
                is KeyboardItem.Enter -> Text(
                    text = "ENTER",
                    style = MaterialTheme.typography.bodySmall,
                )
                is KeyboardItem.Backspace -> Icon(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(20.dp),
                    imageVector = item.icon,
                    contentDescription = null,
                )
                else -> Text(
                    text = (item as WordleChar).label,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

internal class KeyCharPreviewParameterProvider :
    CollectionPreviewParameterProvider<KeyboardItem>(
        listOf(
            WordleChar.Q(status = CharStatus.ExactMatch),
            WordleChar.W(status = CharStatus.CloseMatch),
            WordleChar.E(status = CharStatus.Invalid),
            WordleChar.R(status = CharStatus.Available),
            KeyboardItem.Enter,
            KeyboardItem.Backspace,
        )
    )

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun KeyPreview(
    @PreviewParameter(KeyCharPreviewParameterProvider::class) keyChar: KeyboardItem,
) {
    WordleXTheme {
        Surface {
            KeyboardKey(item = keyChar)
        }
    }
}
