package dev.jimmymorales.wordlex.model

data class Word(
    val char1: WordTile = WordTile.Empty,
    val char2: WordTile = WordTile.Empty,
    val char3: WordTile = WordTile.Empty,
    val char4: WordTile = WordTile.Empty,
    val char5: WordTile = WordTile.Empty,
)

val Word.isEditing: Boolean
    get() = listOf(char1, char2, char3, char4, char5)
        .any { it is WordTile.Empty || it is WordTile.Editing }

fun Word.append(char: WordleChar): Word = when {
    char1 is WordTile.Empty -> copy(char1 = WordTile.Editing(char))
    char2 is WordTile.Empty -> copy(char2 = WordTile.Editing(char))
    char3 is WordTile.Empty -> copy(char3 = WordTile.Editing(char))
    char4 is WordTile.Empty -> copy(char4 = WordTile.Editing(char))
    char5 is WordTile.Empty -> copy(char5 = WordTile.Editing(char))
    else -> this
}
