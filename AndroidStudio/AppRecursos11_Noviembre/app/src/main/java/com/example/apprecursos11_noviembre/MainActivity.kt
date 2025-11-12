package com.example.apprecursos11_noviembre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apprecursos11_noviembre.ui.theme.AppRecursos11_NoviembreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio11Noviembre()
        }
    }
}

val miFuente = FontFamily(
    Font(R.font.mi_fuente_personalizada)
)

@Composable
fun Ejercicio11Noviembre(){
    // Variable para contar (y probar los plurales)
    var contador by remember { mutableStateOf(1) }

    // Necesitamos el "Contexto" para poder acceder a los recursos "plurals"
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        // --- 1. STRING SINGULAR y FUENTE ---
        Text(
            text = stringResource(R.string.titulo_pantalla),
            fontFamily = miFuente, // <-- USO DE FUENTE
            fontSize = 32.sp
        )

        // --- 2. ICONO y COLOR ---
        Icon(
            painter = painterResource(R.drawable.baseline_dark_mode_24), // <-- USO DE ICONO
            contentDescription = "Icono personalizado",
            modifier = Modifier.size(80.dp),
            tint = colorResource(R.color.mi_color_personalizado) // <-- USO DE COLOR
        )

        // --- 3. STRING PLURAL ---
        // Obtenemos el texto plural usando el contexto
        val textoPlural = contexto.resources.getQuantityString(
            R.plurals.contador_elementos, // <-- USO DE PLURAL
            contador, // La cantidad (para decidir "one" u "other")
            contador  // El valor para rellenar el %d
        )

        Text(
            text = textoPlural,
            fontSize = 20.sp
        )

        // --- Botón para probar los plurales ---
        Button(onClick = { contador++ }) {
            Text("Añadir elemento")
        }
    }
}