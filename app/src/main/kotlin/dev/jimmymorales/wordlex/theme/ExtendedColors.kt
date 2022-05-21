package dev.jimmymorales.wordlex.theme

import androidx.annotation.ColorInt
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.android.material.color.ColorRoles
import com.google.android.material.color.MaterialColors

@Stable
data class ExtendedColors(
    val exactMatch: CustomColor,
    val closeMatch: CustomColor,
)

@Stable
data class CustomColor(
    val name: String,
    val color: Color,
) {
    var accent by mutableStateOf(color)
        internal set
    var onAccent by mutableStateOf(color)
        internal set
    var accentContainer by mutableStateOf(color)
        internal set
    var onAccentContainer by mutableStateOf(color)
        internal set
}

internal fun ExtendedColors.harmonize(
    colorScheme: ColorScheme,
    isLight: Boolean
) {
    exactMatch.harmonize(primary = colorScheme.primary, isLight = isLight)
    closeMatch.harmonize(primary = colorScheme.primary, isLight = isLight)
}

private fun CustomColor.harmonize(primary: Color, isLight: Boolean) {
    val harmonizedColor = color.harmonize(primary).getColorRoles(isLight)
    accent = Color(harmonizedColor.accent)
    onAccent = Color(harmonizedColor.onAccent)
    accentContainer = Color(harmonizedColor.accentContainer)
    onAccentContainer = Color(harmonizedColor.onAccentContainer)
}

@ColorInt
private fun Color.harmonize(color: Color): Int = MaterialColors.harmonize(toArgb(), color.toArgb())

private fun @receiver:ColorInt Int.getColorRoles(
    isLight: Boolean = true,
): ColorRoles = MaterialColors.getColorRoles(this, isLight)
