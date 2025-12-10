package com.example.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basics.ui.theme.BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /**
                     * Greeting2(
                     *      names = listOf("Android", "DAM"),
                     *      modifier = Modifier.padding(innerPadding)
                     * )
                     */
                    newWindow(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/** Muestra un saludo en pantalla */
@Composable
fun Greeting(name:String, modifier: Modifier = Modifier){

    // Boton para expandir o contraer el texto
    // Remember guarda el estado del boton
    val expanded = remember { mutableStateOf(false)}

    // Padding para el boton de expandir o contraer
    val extraPadding = if (expanded.value) 64.dp else 0.dp


    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 8.dp)){

        Row(modifier = Modifier.padding(24.dp)) {

            Column(modifier = Modifier.fillMaxWidth().weight(1f).padding(bottom = extraPadding)) {
                Text(
                    text = "Hello",
                    color = Color.White,
                    modifier = modifier
                )
                Text(
                    text = "Hello $name!",
                    color = Color.White,
                )
            }

            ElevatedButton(onClick = { expanded.value = !expanded.value },
                modifier = Modifier.padding(16.dp),
                // Colores del boton
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Magenta))
                {
                    // Texto dentro del boton de expandir o contraer
                    Text(if (expanded.value) "Show less" else "Show more")
                }
        }
    }
}

/** Recorre una lista de nombres y los muestra en pantalla */
@Composable
fun Greeting2(names : List<String>, modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(vertical = 16.dp)) {
        for (name in names){
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicsTheme {
        Greeting("Android")
    }
}

/**
 * Centrar texto y boton
 */
@Composable
fun newWindow(modifier: Modifier = Modifier){
    val state = remember { mutableStateOf(false) }
    Surface(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp).padding(horizontal = 12.dp)){
        Row (modifier = Modifier.padding(24.dp)) {
            Column (modifier = Modifier.padding(24.dp).weight(1f).fillMaxWidth()) {
                Text(text = "Click para cambiar de pantalla")
            }
            ElevatedButton(onClick = {state.value = !state.value}) {
                Text(if (state.value) "Show less" else "Show more")
            }
        }
    }
}