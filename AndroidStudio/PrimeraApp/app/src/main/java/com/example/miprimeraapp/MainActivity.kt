package com.example.miprimeraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miprimeraapp.ui.theme.MiPrimeraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiPrimeraAppTheme {
                saludarVarios()
            }
        }
    }
}

/**
 * Metodo que escribe varias veces el metodo elegido
 */
@Composable
fun saludarVarios(){
    
    HolaMundo("uno")
    HolaMundo("dos")
}

/**
 * Metodo que escribe un texto
 * Modifier --> CSS
 */
@Composable
fun HolaMundo(mensaje : String){
    Text(text = "Jetpack dice  $mensaje", modifier = Modifier.padding(top = 25.dp,))
}

/**
 * Vista previa de un preview sin fondo
 */
@Preview
@Composable
fun HolaMundoPreview(){
    HolaMundo("Vista previa")
}

/**
 * Vista previa de un preview con fondo morado
 */
@Preview (showBackground = true, backgroundColor = 0xFF00FF)
@Composable
fun HolaMundoPreview2(){
    HolaMundo("Vista previa")
}