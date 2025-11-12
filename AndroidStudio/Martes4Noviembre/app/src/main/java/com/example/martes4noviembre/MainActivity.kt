    package com.example.martes4noviembre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.martes4noviembre.ui.theme.Martes4NoviembreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio5Noviembre()
        }
    }
}

@Composable
fun Ejercicio5Noviembre() {

    // 1. Variable para guardar lo que se escribe en la caja de texto
    var nombre by remember { mutableStateOf("") }

    // 2. Variable para guardar el saludo que mostraremos al pulsar el botón
    var saludo by remember { mutableStateOf("") }

    // Column apila los elementos uno DEBAJO del otro (verticalmente)
    Column(
        // Espacio vacío de 16 "píxeles"
        modifier = Modifier
            .padding(20.dp) // <-- Padding de 20 pixeles
            .fillMaxWidth(), // <-- La columna ocupa el ancho entero
        horizontalAlignment = Alignment.CenterHorizontally // <-- Centra horizontalmente
    ) {
        // --- ELEMENTO 1: Texto (Título) ---
        Text(
            text = "Tu App de Saludo",
            // Propiedades directas (no son 'Modifier'):
            fontSize = 26.sp, // <-- TAMAÑO
            fontWeight = FontWeight.Bold, // <-- FUENTE (negrita)
            color = Color(0xFF4A148C) // <-- COLOR (un morado oscuro)
        )

        // Espacio vacío de 24 "píxeles"
        Spacer(modifier = Modifier.height(24.dp))

        // --- ELEMENTO 2: Caja de Texto (TextField) ---
        TextField(
            value = nombre, // El valor que muestra la caja es nuestra variable 'nombre'
            onValueChange = { nombre = it }, // Cuando escribes, actualiza la variable 'nombre'
            label = { Text( text = "Escribe aquí tu nombre") }, // Una etiqueta dentro de la caja
            modifier = Modifier.fillMaxWidth() // <-- Ocupa el ancho entero
        )

        // Espacio vacío de 16 "píxeles"
        Spacer(modifier = Modifier.height(16.dp))

        // --- ELEMENTO 3: Botón ---
        Button(
            onClick = {
                if(nombre.isNotBlank()){
                    saludo = "¡Hola, $nombre!"
                }
            },
            modifier = Modifier.fillMaxWidth(), // <-- Ocupa el ancho entero
            // Propiedad directa para los colores del boton
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB71C1C) // <-- Color (rojo oscuro)
            )
        ) {
            Text("SALÚDAME",
                fontWeight = FontWeight.Bold // <-- Fuente texto boton (negrita)
            )
        }

        // Espacio vacío de 32 "píxeles"
        Spacer(modifier = Modifier.height(32.dp))

        // --- ELEMENTO 4: Texto (Resultado) ---
        Text(
            text = saludo, // Muestra lo que haya en la variable 'saludo'
            // Propiedades directas
            fontSize = 22.sp, // <-- Tamaño
            color = Color.Gray, // <-- Color
            modifier = Modifier.fillMaxWidth(), // <-- Ocupa el ancho entero
            textAlign = TextAlign.Center  // <-- <-- ALINEACIÓN (centra el texto "dentro" de su caja)
        )
    }
}

@Composable
fun Ejercicio4Noviembre(){

    // 1. Variable para guardar lo que se escribe en la caja de texto
    var nombre by remember { mutableStateOf("") }

    // 2. Variable para guardar el saludo que mostraremos al pulsar el botón
    var saludo by remember { mutableStateOf("") }

    // Column apila los elementos uno DEBAJO del otro (verticalmente)
    Column(
        //Padding de 16 "píxeles"
        modifier = Modifier.padding(30.dp)
    ){
        // --- ELEMENTO 1: Texto (Título) ---
        Text(text = "Escribe tu nombre: ", fontSize = 20.sp)

        // Espacio vacío de 8 "píxeles"
        Spacer(modifier = Modifier.height(8.dp))

        // --- ELEMENTO 2: Caja de Texto (TextField) ---
        TextField(
            value = nombre, // El valor que muestra la caja es nuestra variable 'nombre'
            onValueChange = { nombre = it }, // Cuando escribes, actualiza la variable 'nombre'
            label = { Text( text= "Tu nombre") } // Una etiqueta dentro de la caja
        )

        // Espacio vacío de 16 "píxeles"
        Spacer(modifier = Modifier.height(16.dp))

        // --- ELEMENTO 3: Botón ---
        Button(onClick = {
            // La acción del botón:
            // Actualiza la variable 'saludo' con el nuevo texto
            saludo = "¡Hola, $nombre!"
        }) {
            Text("Saludar")
        }

        // Espacio vacío de 16 "píxeles"
        Spacer(modifier = Modifier.height(16.dp))

        // --- ELEMENTO 4: Texto (Resultado) ---
        Text(
            text = saludo // Muestra lo que haya en la variable 'saludo'
        )
    }
}