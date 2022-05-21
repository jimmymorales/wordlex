package dev.jimmymorales.wordlex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.jimmymorales.wordlex.features.board.BoardScreen
import dev.jimmymorales.wordlex.theme.WordleXTheme

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
        BoardScreen(modifier = Modifier.padding(paddingValues))
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    WordleXTheme {
        AppScaffold()
    }
}
