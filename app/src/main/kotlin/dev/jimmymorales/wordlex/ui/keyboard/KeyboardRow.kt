package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        keys.forEachIndexed { index, key ->
            KeyboardKey(
                item = key,
                modifier = Modifier.padding(end = if (index != keys.lastIndex) 8.dp else 0.dp)
            )
        }
    }
}
