package com.example.testbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testbutton.ui.theme.TestButtonTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val licznik = remember{ mutableStateOf(0) }

    Text(text = "Hello $name!")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)

    ) {
        OutlinedButton(
            onClick = {licznik.value+=1},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
                

        )


        {
            Text(
                text = "Login",
                textAlign = TextAlign.Center,
                fontSize = 14.sp

            )
        }
       Spacer(modifier = Modifier.height(20.dp))
        Text(text = licznik.value.toString(), color = Color.Black, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))

       //wskaźnik postępu  indycator
        LinearProgressIndicator(
            progress = 0.0f,
            modifier = Modifier
                .height(8.dp)
                .width(60.dp),
            backgroundColor = Color.LightGray
        )
    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestButtonTheme {
        Greeting("Android")
    }
}