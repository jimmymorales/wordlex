package dev.jimmymorales.wordlex.model

sealed class WordTile {
    abstract val value: WordleChar

    data class Filled(


        override val value: WordleChar) : WordTile()
    data class Editing(override val value: WordleChar) : WordTile()
    object Empty : WordTile() {
        override val value = WordleChar.None
    }
}
