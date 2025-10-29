package com.example.actividad1_ciclosvidaappandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.*

class MainActivity : ComponentActivity(), DefaultLifecycleObserver {
    override fun onCreate(savedInstanceState: Bundle?) {
        super<ComponentActivity>.onCreate(savedInstanceState)
        Log.d("CicloVida", "onCreate ejecutado")

        lifecycle.addObserver(this)

        setContent {
            MiAppTheme {
                Saludo()
            }//MiAppThemeTheme
        }//setContent
    }//onCreate

    // ======== MÉTODOS DEL CICLO DE VIDA ========

    override fun onStart(owner: LifecycleOwner) {
        Log.d("CicloVida", "onStart ejecutado")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d("CicloVida", "onResume ejecutado")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d("CicloVida", "onPause ejecutado")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("CicloVida", "onStop ejecutado")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("CicloVida", "onDestroy ejecutado")
    }
}

@Composable
fun Saludo(){
    Surface(color = MaterialTheme.colorScheme.background) {
        Text(text = "Hola Jetpack Compose! ", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun MiAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography(),
        content = content
    )
}