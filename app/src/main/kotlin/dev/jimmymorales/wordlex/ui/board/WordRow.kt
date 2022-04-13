package dev.jimmymorales.wordlex.ui.board

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jimmymorales.wordlex.ui.model.Word

@Composable
fun WordRow(
    word: Word,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        BoardTile(char = word.char1)
        BoardTile(char = word.char2)
        BoardTile(char = word.char3)
        BoardTile(char = word.char4)
        BoardTile(char = word.char5)
    }
}