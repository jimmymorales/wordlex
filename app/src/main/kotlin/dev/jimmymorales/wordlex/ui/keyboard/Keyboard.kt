package dev.jimmymorales.wordlex.ui.keyboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KeyboardRow(keys = listOf("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"))
        KeyboardRow(keys = listOf("A", "S", "D", "F", "G", "H", "J", "K", "L"))
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
        horizontalArrangement = Arrangement.Center,
    ) {
        keys.forEachIndexed { index, key ->
            Key(value = key, isSelected = index % 2 == 0)
        }
    }
}

@Composable
fun Key(
    value: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Surface(
        modifier = modifier
            .padding(4.dp),
        tonalElevation = if (isSelected) 2.dp else 16.dp,
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .defaultMinSize(minWidth = 32.dp, minHeight = 32.dp)
                .clickable {
                    // TODO: Select Key
                }
                .padding(4.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = value,
            )
        }
    }
}

@Preview
@Composable
fun KeyPreview() {
    WordleXTheme {
        Key("Q")
    }
}
