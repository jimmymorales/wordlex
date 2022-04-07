package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KeyboardRow(keys = listOf("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"))
        KeyboardRow(keys = listOf("A", "S", "D", "E", "F", "G", "H", "J", "K", "L"))
        KeyboardRow(keys = listOf("ENTER", "Z", "X", "C", "V", "B", "N", "M", "<"))
    }
}

@Composable
fun KeyboardRow(
    keys: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        keys.forEach { key ->
            Key(value = key)
        }
    }
}

@Composable
fun Key(
    value: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        onClick = { /*TODO*/ },
    ) {
        Text(value)
    }
}

@Preview
@Composable
fun KeyPreview() {
    WordleXTheme {
        Key("Q")
    }
}
