package io.king.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.king.state.ui.theme.StateTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = remember { mutableStateOf(Color.Green)}
            Column(Modifier.fillMaxSize()) {
                ColorBox (Modifier.weight(1f)){color.value = it}
                Box(Modifier.background(color.value).weight(1f).fillMaxSize())
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(.5f)
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    alpha = 1f
                )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var color = remember { mutableStateOf(Color.Green)}
    Column(Modifier.fillMaxSize()) {
        ColorBox (Modifier.weight(1f).fillMaxSize()){color.value = it}
        Box(Modifier.weight(1f).fillMaxSize().background(color.value))
    }
}