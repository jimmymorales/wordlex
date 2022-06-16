package dev.jimmymorales.wordlex.model

data class BoardState(
    val word1: Word = Word(),
    val word2: Word = Word(),
    val word3: Word = Word(),
    val word4: Word = Word(),
    val word5: Word = Word(),
    val word6: Word = Word(),
)

val BoardState.currentWordIndex: Int
    get() = listOf(word1, word2, word3, word4, word5, word6)
        .indexOfFirst(Word::isEditing)

operator fun BoardState.get(index: Int): Word? = when (index) {
    Word1 -> word1
    Word2 -> word2
    Word3 -> word3
    Word4 -> word4
    Word5 -> word5
    Word6 -> word6
    else -> null
}

fun BoardState.update(index: Int, word: Word): BoardState {
    return when (index) {
        Word1 -> copy(word1 = word)
        Word2 -> copy(word2 = word)
        Word3 -> copy(word3 = word)
        Word4 -> copy(word4 = word)
        Word5 -> copy(word5 = word)
        Word6 -> copy(word6 = word)
        else -> this
    }
}

private const val Word1: Int = 0
private const val Word2: Int = 1
private const val Word3: Int = 2
private const val Word4: Int = 3
private const val Word5: Int = 4
private const val Word6: Int = 5
