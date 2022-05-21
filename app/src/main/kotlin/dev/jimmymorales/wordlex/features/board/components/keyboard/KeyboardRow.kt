package dev.jimmymorales.wordlex.features.board.components.keyboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.model.KeyboardItem
import dev.jimmymorales.wordlex.model.WordleChar
import dev.jimmymorales.wordlex.theme.WordleXTheme
import dev.jimmymorales.wordlex.theme.icons.Backspace

@Composable
fun KeyboardRow(
    keys: List<KeyboardItem>,
    modifier: Modifier = Modifier,
    onKeyPressed: (KeyboardItem) -> Unit = {},
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
    ) {
        keys.forEachIndexed { index, key ->
            KeyboardKey(
                item = key,
                modifier = Modifier.padding(end = if (index != keys.lastIndex) 8.dp else 0.dp),
                onKeyPressed = onKeyPressed,
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun KeyboardRowPreview() {
    WordleXTheme {
        Surface {
            val keysSample = listOf(
                KeyboardItem.Enter,
                KeyboardItem.KeyChar(value = WordleChar.Z),
                KeyboardItem.KeyChar(value = WordleChar.X, status = CharStatus.ExactMatch),
                KeyboardItem.KeyChar(value = WordleChar.C),
                KeyboardItem.KeyChar(value = WordleChar.V, status = CharStatus.Invalid),
                KeyboardItem.KeyChar(value = WordleChar.B),
                KeyboardItem.KeyChar(value = WordleChar.N, status = CharStatus.CloseMatch),
                KeyboardItem.KeyChar(value = WordleChar.M),
                KeyboardItem.Icon(Icons.Filled.Backspace),
            )
            KeyboardRow(keysSample)
        }
    }
}
