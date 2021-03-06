package dev.jimmymorales.wordlex.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.theme.extendedColors

internal val CharStatus.backgroundColor: Color
    @ReadOnlyComposable
    @Composable
    get() {
        val colorScheme = MaterialTheme.colorScheme
        val extendedColors = MaterialTheme.extendedColors
        return when (this) {
            CharStatus.ExactMatch -> extendedColors.exactMatch.accentContainer
            CharStatus.CloseMatch -> extendedColors.closeMatch.accentContainer
            CharStatus.Invalid,
            CharStatus.Available -> colorScheme.surface
        }
    }

internal val CharStatus.contentColor: Color
    @ReadOnlyComposable
    @Composable
    get() {
        val extendedColors = MaterialTheme.extendedColors
        return when (this) {
            CharStatus.ExactMatch -> extendedColors.exactMatch.onAccentContainer
            CharStatus.CloseMatch -> extendedColors.closeMatch.onAccentContainer
            CharStatus.Invalid,
            CharStatus.Available -> contentColorFor(backgroundColor = backgroundColor)
        }
    }
