package dev.jimmymorales.wordlex.model

import androidx.compose.runtime.Stable

@Stable
sealed class WordleChar : KeyboardItem {
    abstract val status: CharStatus

    data class A(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class B(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class C(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class D(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class E(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class F(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class G(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class H(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class I(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class J(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class K(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class L(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class M(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class N(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class O(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class P(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class Q(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class R(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class S(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class T(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class U(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class V(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class W(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class X(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class Y(override val status: CharStatus = CharStatus.Available) : WordleChar()
    data class Z(override val status: CharStatus = CharStatus.Available) : WordleChar()

    object None : WordleChar() {
        override val status = CharStatus.Available
    }
}

val WordleChar.label: String
    get() = when (this) {
        is WordleChar.A -> "A"
        is WordleChar.B -> "B"
        is WordleChar.C -> "C"
        is WordleChar.D -> "D"
        is WordleChar.E -> "E"
        is WordleChar.F -> "F"
        is WordleChar.G -> "G"
        is WordleChar.H -> "H"
        is WordleChar.I -> "I"
        is WordleChar.J -> "J"
        is WordleChar.K -> "K"
        is WordleChar.L -> "L"
        is WordleChar.M -> "M"
        is WordleChar.N -> "N"
        is WordleChar.O -> "O"
        is WordleChar.P -> "P"
        is WordleChar.Q -> "Q"
        is WordleChar.R -> "R"
        is WordleChar.S -> "S"
        is WordleChar.T -> "T"
        is WordleChar.U -> "U"
        is WordleChar.V -> "V"
        is WordleChar.W -> "W"
        is WordleChar.X -> "X"
        is WordleChar.Y -> "Y"
        is WordleChar.Z -> "Z"
        is WordleChar.None -> ""
    }
