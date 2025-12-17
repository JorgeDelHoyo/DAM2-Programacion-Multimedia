package com.example.basics

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
                    gestorPantallas(modifier = Modifier.padding(innerPadding))
                    //Greetings(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/** Muestra un saludo en pantalla */
@Composable
fun Greeting(name:String, modifier: Modifier = Modifier){

    val expanded = rememberSaveable { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp


    Surface(color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){

        Row(modifier = Modifier.padding(24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(extraPadding)) {
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
    Column (modifier = Modifier.padding(vertical = 0.dp)) {
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
        Text(text = "Bienvenidos a nuestra app")
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
    // RememberSaveable guarda el estado de la variable aunque cambien los externo
    val estado = rememberSaveable { mutableStateOf(true) }

    val volver = rememberSaveable { mutableStateOf(false) }

    if(estado.value){
        nuevaPantalla(modifier,estado)
    }else {
            if(volver.value){
                estado.value = true
                volver.value = false
            }
            //Greeting2(names = listOf("Android", "DAM"), modifier = modifier)
            Greetings(modifier = modifier, onBackHome = { volver.value = true })
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Greetings
            (modifier: Modifier = Modifier,
             names : List<String> = List(100){"$it"},
             onBackHome: () -> Unit
) {
    // Introducir dentro del scaffold para que "Flote" el boton
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text("Volver")},
                navigationIcon = {
                    IconButton(onClick = onBackHome) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onBackHome,modifier=Modifier) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }
    }
}