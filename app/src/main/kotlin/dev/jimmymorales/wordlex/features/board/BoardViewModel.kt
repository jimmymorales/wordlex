package dev.jimmymorales.wordlex.features.board

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jimmymorales.wordlex.model.BoardState
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.model.KeyboardItem
import dev.jimmymorales.wordlex.model.KeyboardState
import dev.jimmymorales.wordlex.model.Word
import dev.jimmymorales.wordlex.model.WordTile
import dev.jimmymorales.wordlex.model.WordleChar
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan

class BoardViewModel : ViewModel() {
    private val internalState = MutableStateFlow(mockGame)
    val state: StateFlow<GameState> = internalState.asStateFlow()

    private val intents = MutableSharedFlow<BoardIntent>(extraBufferCapacity = 64)

    init {
        intents
            .scan(mockGame) { currentState, intent ->
                println("New intent = $intent")
                currentState
            }
            .onEach { newState ->
                internalState.value = newState
            }
            .launchIn(viewModelScope)
    }

    fun onIntent(intent: BoardIntent) {
        intents.tryEmit(intent)
    }
}

data class GameState(
    val board: BoardState,
    val keyboard: KeyboardState,
)

sealed interface BoardIntent {
    data class KeyPressed(val key: KeyboardItem) : BoardIntent
}

internal val mockBoard = BoardState(
    word1 = Word(
        WordTile.Filled(value = WordleChar.R, status = CharStatus.ExactMatch),
        WordTile.Filled(value = WordleChar.A, status = CharStatus.CloseMatch),
        WordTile.Filled(value = WordleChar.D, status = CharStatus.Invalid),
        WordTile.Filled(value = WordleChar.I, status = CharStatus.Invalid),
        WordTile.Filled(value = WordleChar.O, status = CharStatus.CloseMatch),
    ),
    word2 = Word(
        WordTile.Editing(value = WordleChar.R),
        WordTile.Empty,
        WordTile.Empty,
        WordTile.Empty,
        WordTile.Empty,
    ),
)

private val mockGame = GameState(
    board = mockBoard,
    keyboard = KeyboardState(),
)
