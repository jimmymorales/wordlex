package dev.jimmymorales.wordlex.ui.model

data class BoardState(
    val word1: Word = Word(),
    val word2: Word = Word(),
    val word3: Word = Word(),
    val word4: Word = Word(),
    val word5: Word = Word(),
    val word6: Word = Word(),
)

data class Word(
    val char1: WordTile = WordTile.Empty,
    val char2: WordTile = WordTile.Empty,
    val char3: WordTile = WordTile.Empty,
    val char4: WordTile = WordTile.Empty,
    val char5: WordTile = WordTile.Empty,
)

sealed class WordTile {
    abstract val value: WordleChar

    data class Filled(override val value: WordleChar, val status: CharStatus) : WordTile()
    data class Editing(override val value: WordleChar) : WordTile()
    object Empty : WordTile() {
        override val value: WordleChar = WordleChar.Empty
    }
}
