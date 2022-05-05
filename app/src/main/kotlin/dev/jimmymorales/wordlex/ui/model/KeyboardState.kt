package dev.jimmymorales.wordlex.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import dev.jimmymorales.wordlex.ui.theme.icons.Backspace

data class KeyboardState(
    val row1: List<KeyboardItem> = listOf(
        KeyboardItem.KeyChar(value = WordleChar.Q),
        KeyboardItem.KeyChar(value = WordleChar.W),
        KeyboardItem.KeyChar(value = WordleChar.E),
        KeyboardItem.KeyChar(value = WordleChar.R, status = CharStatus.ExactMatch),
        KeyboardItem.KeyChar(value = WordleChar.T),
        KeyboardItem.KeyChar(value = WordleChar.Y),
        KeyboardItem.KeyChar(value = WordleChar.U),
        KeyboardItem.KeyChar(value = WordleChar.I, status = CharStatus.Invalid),
        KeyboardItem.KeyChar(value = WordleChar.O, status = CharStatus.CloseMatch),
        KeyboardItem.KeyChar(value = WordleChar.P),
    ),
    val row2: List<KeyboardItem> = listOf(
        KeyboardItem.KeyChar(value = WordleChar.A, status = CharStatus.CloseMatch),
        KeyboardItem.KeyChar(value = WordleChar.S),
        KeyboardItem.KeyChar(value = WordleChar.D, status = CharStatus.Invalid),
        KeyboardItem.KeyChar(value = WordleChar.F),
        KeyboardItem.KeyChar(value = WordleChar.G),
        KeyboardItem.KeyChar(value = WordleChar.H),
        KeyboardItem.KeyChar(value = WordleChar.J),
        KeyboardItem.KeyChar(value = WordleChar.K),
        KeyboardItem.KeyChar(value = WordleChar.L),
    ),
    val row3: List<KeyboardItem> = listOf(
        KeyboardItem.Enter,
        KeyboardItem.KeyChar(value = WordleChar.Z),
        KeyboardItem.KeyChar(value = WordleChar.X),
        KeyboardItem.KeyChar(value = WordleChar.C),
        KeyboardItem.KeyChar(value = WordleChar.V),
        KeyboardItem.KeyChar(value = WordleChar.B),
        KeyboardItem.KeyChar(value = WordleChar.N),
        KeyboardItem.KeyChar(value = WordleChar.M),
        KeyboardItem.Icon(Icons.Filled.Backspace),
    ),
)

@Stable
sealed interface KeyboardItem {
    data class KeyChar(
        val value: WordleChar,
        val status: CharStatus = CharStatus.Available,
    ) : KeyboardItem

    data class Icon(val value: ImageVector) : KeyboardItem
    object Enter : KeyboardItem
}
