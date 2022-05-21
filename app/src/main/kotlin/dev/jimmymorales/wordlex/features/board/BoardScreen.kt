package dev.jimmymorales.wordlex.features.board

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jimmymorales.wordlex.features.board.components.Board
import dev.jimmymorales.wordlex.features.board.components.mockBoard
import dev.jimmymorales.wordlex.features.board.components.keyboard.Keyboard
import dev.jimmymorales.wordlex.model.KeyboardState
import dev.jimmymorales.wordlex.theme.WordleXTheme

@Composable
fun BoardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Board(
            board = mockBoard, modifier = Modifier.weight(1f)
        )
        Keyboard(state = KeyboardState())
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BoardPreview() {
    WordleXTheme {
        Surface {
            BoardScreen()
        }
    }
}
