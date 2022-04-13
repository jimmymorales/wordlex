package dev.jimmymorales.wordlex.ui.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import dev.jimmymorales.wordlex.ui.model.CharStatus
import dev.jimmymorales.wordlex.ui.theme.LocalExtendedColors

internal val CharStatus.backgroundColor: Color
    @ReadOnlyComposable
    @Composable
    get() {
        val colorScheme = MaterialTheme.colorScheme
        val extendedColors = LocalExtendedColors.current
        return when (this) {
            CharStatus.ExactMatch -> Color(extendedColors.exactMatch.roles.accentContainer)
            CharStatus.CloseMatch -> Color(extendedColors.closeMatch.roles.accentContainer)
            CharStatus.Invalid,
            CharStatus.Available -> colorScheme.surface
        }
    }

internal val CharStatus.contentColor: Color
    @ReadOnlyComposable
    @Composable
    get() {
        val extendedColors = LocalExtendedColors.current
        return when (this) {
            CharStatus.ExactMatch -> Color(extendedColors.exactMatch.roles.onAccentContainer)
            CharStatus.CloseMatch -> Color(extendedColors.closeMatch.roles.onAccentContainer)
            CharStatus.Invalid,
            CharStatus.Available -> contentColorFor(backgroundColor = backgroundColor)
        }
    }
