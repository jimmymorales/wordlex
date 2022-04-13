package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jimmymorales.wordlex.ui.model.KeyboardItem

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
            KeyboardKey(item = key)
        }
    }
}