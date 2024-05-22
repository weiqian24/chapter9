package com.example.chapter9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animation
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chapter9.ui.theme.Chapter9Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.Button
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter9Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Animation()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun Animation(){
    var appear by remember { mutableStateOf(true) }  //背景出現
    var expanded by remember { mutableStateOf(true) }  //背景延展
    var fly by remember { mutableStateOf(false) }  //火箭升空

    Column {
        Button(
            onClick = { appear = !appear }
        ) {
            if (appear) Text(text = "星空背景圖消失")
            else Text(text = "星空背景圖出現")
        }

        Image(
            painter = painterResource(id = R.drawable.sky),
            contentDescription = "星空背景圖"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chapter9Theme {
        Greeting("Android")
    }
}