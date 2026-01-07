package com.example.claser

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.claser.ui.theme.ClaseRTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClaseRTheme {
                Scaffold(topBar = {TopBar()}) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        ContenidoPrincipal()
                    }
                }
            }
        }
    }
}

/**
 * Barra superior
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1976D2), // Azul
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        title = {
            Text(text = "Información alumno", fontWeight = FontWeight.Bold)
        },
        navigationIcon = {
            IconButton(onClick = { /* Acción*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_backwhite_24dp_24),
                    contentDescription = "Atrás",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Acción*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.person_24dp_24),
                    contentDescription = "Perfil",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun ContenidoPrincipal(modifier: Modifier = Modifier){

    // VARIABLES DE ESTADO (Para guardar lo que escribe el usuario)
    var nombre by remember { mutableStateOf("") } // Nombre introducido por el usuario
    var apellidos by remember { mutableStateOf("") } // Apellido introducido por el usuario
    var expanded by remember { mutableStateOf(false) } // Si el menú está abierto o cerrado
    var numeroHermanos by remember { mutableStateOf("") } // Texto que se muestra
    var resultado by remember { mutableStateOf("") } // Resultado final

    // OPCIONES DEL MENU
    val opciones = listOf("1 hermano", "2 hermanos", "Más de 2 hermanos")

    // Ordenación tipo columna
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Margen general
        verticalArrangement = Arrangement.Top // Espacio entre elementos
    ) {
        Text(text = "Nombre:")
        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("Ingrese nombre") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(Modifier.height(16.dp))

        Text(text="Apellidos:")
        OutlinedTextField(
            value = apellidos,
            onValueChange = {apellidos = it},
            label = {Text("Ingrese apellidos")},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(Modifier.height(16.dp))

        Text(text = "Número de hermanos:")

        // Box para contener el TextField y el Menú desplegable
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = if (numeroHermanos.isEmpty()) "Seleccionar" else numeroHermanos,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    // El icono es un botón que abre/cierra el menú
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Desplegar")
                    }
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                opciones.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(text = opcion) },
                        onClick = {
                            numeroHermanos = opcion
                            expanded = false // Cerramos el menú al elegir
                        }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(100.dp))

        // --- TEXTO RESULTADO ---
        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Información al pulsar el botón
        Button(
            onClick = {
                resultado = "Soy $nombre $apellidos y tengo $numeroHermanos"
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), // Altura un poco mayor para parecerse a la imagen
            shape = MaterialTheme.shapes.extraSmall, // Bordes menos redondeados (opcional, según gusto)
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
        ) {
            Text(text = "Mostrar", fontSize = androidx.compose.ui.unit.TextUnit.Unspecified)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    ClaseRTheme {
        Scaffold(topBar = { TopBar() }) {
            ContenidoPrincipal(Modifier.padding(it))
        }
    }
}
