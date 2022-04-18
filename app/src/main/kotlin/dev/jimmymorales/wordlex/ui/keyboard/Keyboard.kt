package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.ui.model.KeyboardState

@Composable
fun Keyboard(
    keyboard: KeyboardState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KeyboardRow(keys = keyboard.row1, modifier = Modifier.padding(bottom = 8.dp))
        KeyboardRow(keys = keyboard.row2, modifier = Modifier.padding(bottom = 8.dp))
        KeyboardRow(keys = keyboard.row3)
    }
}
