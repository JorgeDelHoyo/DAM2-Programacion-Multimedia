package com.example.batallapokemon

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.batallapokemon.ui.theme.BatallaPokemonTheme
import kotlin.math.exp

/* BATALLA POKEMON
* Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla pokemon.
* - La formula será la siguiente: daño = 50 * (ataque/defensa) * efectividad
* - Efectividad : x2 (super efectivo), x1 (neutral), x0.5 (No es muy efectivo)
* - Solo hay 4 tipos de pókemon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
* - El programa recibe los siguientes parámetros:
*    - Tipo del pokemon atacante
*    - Tipo del pokemon defensor
*    - Ataque: Entre 1 y 100
*    - Defensa entre 1 y 100
*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            BatallaPokemonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaBatalla(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaBatalla(modifier: Modifier = Modifier){
    var tipoAtacante by remember { mutableStateOf("Agua") }
    var tipoDefensor by remember { mutableStateOf("Fuego") }
    var ataque by remember { mutableStateOf("")}
    var defensa by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Esperando datos...") }

    val tipos = listOf("Agua", "Fuego", "Planta", "Eléctrico")

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(text =  "BATALLA PÓKEMON", style = MaterialTheme.typography.headlineMedium)

        // Seleccionar tipo atacante
        Text(text = "Tipo Atacante: ")
        SelectorTipo(
            tipos = tipos,
            seleccionado = tipoAtacante,
            alSeleccionar = { tipoAtacante = it }
        )
        // Seleccionar tipo defensor
        Text(text = "Tipo Defensor: ")
        SelectorTipo(
            tipos = tipos,
            seleccionado = tipoDefensor,
            alSeleccionar = {tipoDefensor = it}
        )
        OutlinedTextField(
            value = ataque,
            onValueChange = {ataque =  it},
            label = {Text("Ataque (1-100)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        OutlinedTextField(
            value = defensa,
            onValueChange = {defensa = it},
            label = { Text("Defensa (1-100)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Button(
            onClick = {
                val ataqueB = ataque.toDoubleOrNull() ?: 0.0
                val defensaB = defensa.toDoubleOrNull() ?: 0.0

                if (ataqueB in 1.0..100.0 && defensaB in 1.0..100.0){
                    val danio = calcularDanio(tipoAtacante, tipoDefensor, ataqueB, defensaB)
                    resultado = "Daño total: $danio"
                }else {
                    resultado = "Error: Stats debem ser 1-100"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("ATACAR") }

        Text(
            text = resultado,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectorTipo ( tipos : List<String>, seleccionado: String, alSeleccionar: (String) -> Unit) {
    var expandido by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expandido,
        onExpandedChange = { expandido = !expandido }
    ) {
        TextField(
            value = seleccionado,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandido)},
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expandido,
            onDismissRequest = {expandido = false}
        ) {
            tipos.forEach { tipo ->
                DropdownMenuItem(
                    text = {Text(tipo)},
                    onClick = {
                        alSeleccionar(tipo)
                        expandido = false
                    }
                )
            }
        }
    }
}

/**
 * Metodo para calcular el daño que realiza el pokemon segun su tipo
 */
private fun calcularDanio(tipoAtacante: String, tipoDefensor:String, ataque:Double, defensa:Double) : Double {
    var efectividad = 1.0

    when(tipoAtacante){
        "Agua" -> {
            if (tipoDefensor == "Fuego") efectividad = 2.0
            if (tipoDefensor == "Planta" || tipoDefensor == "Agua") efectividad = 0.5
        }
        "Fuego" -> {
            if (tipoDefensor == "Planta") efectividad = 2.0
            if (tipoDefensor == "Agua" || tipoDefensor == "Fuego") efectividad = 0.5
        }
        "Planta" -> {
            if (tipoDefensor == "Agua") efectividad = 2.0
            if (tipoDefensor == "Planta" || tipoDefensor == "Electrico") efectividad = 0.5
        }
    }
    return 50 * (ataque/defensa) * efectividad
}

