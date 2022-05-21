package dev.jimmymorales.wordlex.features.board.components.keyboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jimmymorales.wordlex.model.KeyboardItem
import dev.jimmymorales.wordlex.model.KeyboardState
import dev.jimmymorales.wordlex.theme.WordleXTheme

@Composable
fun Keyboard(
    state: KeyboardState,
    modifier: Modifier = Modifier,
    onKeyPressed: (KeyboardItem) -> Unit = {},
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        KeyboardRow(
            keys = state.row1,
            modifier = Modifier.padding(bottom = 8.dp),
            onKeyPressed = onKeyPressed
        )
        KeyboardRow(
            keys = state.row2,
            modifier = Modifier.padding(bottom = 8.dp),
            onKeyPressed = onKeyPressed
        )
        KeyboardRow(keys = state.row3, onKeyPressed = onKeyPressed)
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun KeyboardPreview() {
    WordleXTheme {
        Surface {
            Keyboard(state = KeyboardState())
        }
    }
}
