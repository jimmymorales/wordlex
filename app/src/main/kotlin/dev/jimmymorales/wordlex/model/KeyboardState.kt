package dev.jimmymorales.wordlex.model

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Stable
import dev.jimmymorales.wordlex.theme.icons.Backspace

data class KeyboardState(
    val a: WordleChar.A = WordleChar.A(),
    val b: WordleChar.B = WordleChar.B(),
    val c: WordleChar.C = WordleChar.C(),
    val d: WordleChar.D = WordleChar.D(),
    val e: WordleChar.E = WordleChar.E(),
    val f: WordleChar.F = WordleChar.F(),
    val g: WordleChar.G = WordleChar.G(),
    val h: WordleChar.H = WordleChar.H(),
    val i: WordleChar.I = WordleChar.I(),
    val j: WordleChar.J = WordleChar.J(),
    val k: WordleChar.K = WordleChar.K(),
    val l: WordleChar.L = WordleChar.L(),
    val m: WordleChar.M = WordleChar.M(),
    val n: WordleChar.N = WordleChar.N(),
    val o: WordleChar.O = WordleChar.O(),
    val p: WordleChar.P = WordleChar.P(),
    val q: WordleChar.Q = WordleChar.Q(),
    val r: WordleChar.R = WordleChar.R(),
    val s: WordleChar.S = WordleChar.S(),
    val t: WordleChar.T = WordleChar.T(),
    val u: WordleChar.U = WordleChar.U(),
    val v: WordleChar.V = WordleChar.V(),
    val w: WordleChar.W = WordleChar.W(),
    val x: WordleChar.X = WordleChar.X(),
    val y: WordleChar.Y = WordleChar.Y(),
    val z: WordleChar.Z = WordleChar.Z(),
)

@Stable
sealed interface KeyboardItem {
    object Backspace : KeyboardItem {
        val icon = Icons.Filled.Backspace
    }

    object Enter : KeyboardItem
}
