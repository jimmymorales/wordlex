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
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KeyboardRow(keys = keyboard.row1)
        KeyboardRow(keys = keyboard.row2)
        KeyboardRow(keys = keyboard.row3)
    }
}
