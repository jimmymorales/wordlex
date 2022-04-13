package dev.jimmymorales.wordlex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.jimmymorales.wordlex.ui.board.Board
import dev.jimmymorales.wordlex.ui.keyboard.Keyboard
import dev.jimmymorales.wordlex.ui.model.BoardState
import dev.jimmymorales.wordlex.ui.model.CharStatus
import dev.jimmymorales.wordlex.ui.model.KeyboardState
import dev.jimmymorales.wordlex.ui.model.Word
import dev.jimmymorales.wordlex.ui.model.WordTile
import dev.jimmymorales.wordlex.ui.model.WordleChar
import dev.jimmymorales.wordlex.ui.theme.WordleXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordleXTheme {
                AppScaffold()
            }
        }
    }
}

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Board(
                board = mockBoard,
                modifier = Modifier.weight(1f)
            )
            Keyboard(keyboard = KeyboardState())
        }
    }
}

private val mockBoard = BoardState(
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WordleXTheme {
        AppScaffold()
    }
}