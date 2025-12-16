package com.example.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateBounds
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basics.ui.theme.BasicsTheme
import kotlin.math.exp

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
                    //gestorPantallas(modifier = Modifier.padding(innerPadding))
                    Greetings(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/** Muestra un saludo en pantalla */
@Composable
fun Greeting(name:String, modifier: Modifier = Modifier){

    val expanded = rememberSaveable { mutableStateOf(false) }

    Surface(color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){

        Row(modifier = Modifier.padding(24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow))) {

            Column(modifier = Modifier.weight(1f)) {
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


@Composable
fun nuevaPantalla(modifier: Modifier = Modifier, estado : MutableState<Boolean>){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Bienvenidos a neustra app")
        ElevatedButton(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { estado.value = false },
        ) {
            Text(text = "Continue",
                color = Color.Magenta)
        }
    }
}

@Composable
fun gestorPantallas (modifier: Modifier = Modifier){
    // RememberSaveable guarda el estado de la variable aunque cambien los externos
    val estado = rememberSaveable { mutableStateOf(true) }

    if(estado.value){
        nuevaPantalla(modifier,estado)
    }else{
        Greeting2(names = listOf("Android", "DAM"), modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun nuevaPantallaPreview() {
    BasicsTheme {
        gestorPantallas()
    }
}

/**
 * Recorre una lista de nombres y los muestra en pantalla
 */
@Composable
private fun Greetings
            (modifier: Modifier = Modifier,
             names : List<String> = List(1000){"$it"}
){
    LazyColumn(modifier = modifier.padding(vertical = 20.dp)) {
        items(items = names){ name -> Greeting(name = name) }
    }
}