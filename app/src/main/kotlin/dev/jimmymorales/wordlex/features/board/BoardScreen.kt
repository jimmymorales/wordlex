package dev.jimmymorales.wordlex.features.board

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jimmymorales.wordlex.features.board.components.Board
import dev.jimmymorales.wordlex.features.board.components.keyboard.Keyboard
import dev.jimmymorales.wordlex.theme.WordleXTheme

@Composable
fun BoardScreen(
    modifier: Modifier = Modifier,
    viewModel: BoardViewModel = viewModel(),
) {
    val uiState by viewModel.state.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Board(
            board = uiState.board, modifier = Modifier.weight(1f)
        )
        Keyboard(state = uiState.keyboard)
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
