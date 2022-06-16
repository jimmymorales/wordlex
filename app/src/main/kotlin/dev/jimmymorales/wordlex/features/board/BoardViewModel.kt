package dev.jimmymorales.wordlex.features.board

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jimmymorales.wordlex.features.board.middleware.InsertCharMiddleware
import dev.jimmymorales.wordlex.features.board.reducers.boardReducer
import dev.jimmymorales.wordlex.model.BoardState
import dev.jimmymorales.wordlex.model.CharStatus
import dev.jimmymorales.wordlex.model.KeyboardItem
import dev.jimmymorales.wordlex.model.KeyboardState
import dev.jimmymorales.wordlex.model.Word
import dev.jimmymorales.wordlex.model.WordTile
import dev.jimmymorales.wordlex.model.WordleChar
import dev.jimmymorales.wordlex.mvi.MviStore
import dev.jimmymorales.wordlex.mvi.ReduceAction
import dev.jimmymorales.wordlex.mvi.Store
import dev.jimmymorales.wordlex.mvi.ViewIntent
import dev.jimmymorales.wordlex.mvi.ViewState

class BoardViewModel : ViewModel(), Store<GameState, GameIntent, GameReduceAction> {
    private val store = MviStore(
        initialState = GameState(),
        scope = viewModelScope,
        middlewares = listOf(
            InsertCharMiddleware()
        ),
        reducer = boardReducer,
    )
    override val state = store.state

    override fun onIntent(intent: GameIntent) {
        store.onIntent(intent)
    }
}

data class GameState(
    val board: BoardState = BoardState(),
    val keyboard: KeyboardState = KeyboardState(),
) : ViewState

sealed interface GameIntent : ViewIntent {
    data class KeyPressed(val key: KeyboardItem) : GameIntent
}

sealed interface GameReduceAction : ReduceAction {
    data class UpdateWord(val index: Int, val word: Word) : GameReduceAction
}

internal val mockBoard = BoardState(
    word1 = Word(
        WordTile.Filled(value = WordleChar.A(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.U(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.D(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.I(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.O(status = CharStatus.Invalid)),
    ),
    word2 = Word(
        WordTile.Filled(value = WordleChar.M(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.E(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.A(status = CharStatus.CloseMatch)),
        WordTile.Filled(value = WordleChar.N(status = CharStatus.Invalid)),
        WordTile.Filled(value = WordleChar.T(status = CharStatus.Invalid)),
    ),
    word3 = Word(
        WordTile.Filled(value = WordleChar.G(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.A(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.M(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.E(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.S(status = CharStatus.Invalid)),
    ),
    word4 = Word(
        WordTile.Filled(value = WordleChar.G(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.A(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.M(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.E(status = CharStatus.ExactMatch)),
        WordTile.Filled(value = WordleChar.R(status = CharStatus.ExactMatch)),
    ),
)

internal val mockKeyboard = KeyboardState(
    a = WordleChar.A(status = CharStatus.CloseMatch),
    d = WordleChar.D(status = CharStatus.Invalid),
    i = WordleChar.I(status = CharStatus.Invalid),
    o = WordleChar.O(status = CharStatus.CloseMatch),
    r = WordleChar.R(status = CharStatus.ExactMatch),
)

/*private val mockGame = GameState(
    board = mockBoard,
    keyboard = mockKeyboard,
)*/
