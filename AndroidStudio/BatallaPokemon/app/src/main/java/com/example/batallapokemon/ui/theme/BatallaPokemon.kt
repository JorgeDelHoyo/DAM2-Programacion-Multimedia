package com.example.batallapokemon.ui.theme

// 1. Definimos la Enum Class fuera para que sea accesible globalmente
enum class TipoPokemon {
    AGUA, FUEGO, PLANTA, ELECTRICO
}

fun main() {
    println("--- SIMULADOR DE BATALLA POKÉMON (V2.0) ---")

    // Mostramos los valores posibles del Enum
    // joinToString nos ayuda a imprimirlos bonitos separados por comas
    println("Tipos válidos: ${TipoPokemon.values().joinToString(", ")}")
    println("-------------------------------------------")

    try {
        // --- ENTRADA DE DATOS ---

        print("Introduce el Tipo del Atacante: ")
        // uppercase() es vital porque los Enums suelen estar en MAYÚSCULAS
        val inputAtacante = readln().trim().uppercase()
        // Convertimos el String al Enum. Si no existe, lanzará error (lo capturamos abajo)
        val tipoAtacante = TipoPokemon.valueOf(inputAtacante)

        print("Introduce el Tipo del Defensor: ")
        val inputDefensor = readln().trim().uppercase()
        val tipoDefensor = TipoPokemon.valueOf(inputDefensor)

        print("Introduce el Ataque (1-100): ")
        val ataque = readln().toDouble()

        print("Introduce la Defensa (1-100): ")
        val defensa = readln().toDouble()

        // --- 2. EL IF DE COMPROBACIÓN (Lo que pediste) ---
        // Comprobamos si se sale por arriba (>100) o por abajo (<0 o <=0 para defensa)
        if (ataque > 100 || ataque <= 0 || defensa > 100 || defensa <= 0) {
            println("ERROR: El ataque y la defensa deben ser valores entre 1 y 100.")
        } else {
            // Si pasa el if, calculamos
            val danio = calcularDanio(tipoAtacante, tipoDefensor, ataque, defensa)

            println("-------------------------------------------")
            println("Resultado: El $tipoAtacante ataca a $tipoDefensor")
            println("Daño infligido: $danio")
        }

    } catch (e: IllegalArgumentException) {
        // Este error salta si escriben un tipo que no está en el Enum (ej: "Hielo")
        println("ERROR: Has introducido un Tipo de Pokémon que no existe o está mal escrito.")
    } catch (e: NumberFormatException) {
        // Este error salta si escriben letras en vez de números en ataque/defensa
        println("ERROR: El ataque y defensa deben ser números.")
    }
}

// La función ahora recibe tipos 'TipoPokemon', no Strings. Es más seguro.
fun calcularDanio(atacante: TipoPokemon, defensor: TipoPokemon, ataque: Double, defensa: Double): Double {
    var efectividad = 1.0

    // Usamos el Enum en el when. Kotlin es listo y sabe que son tipos de la Enum.
    when (atacante) {
        TipoPokemon.AGUA -> {
            if (defensor == TipoPokemon.FUEGO) efectividad = 2.0
            if (defensor == TipoPokemon.PLANTA || defensor == TipoPokemon.AGUA) efectividad = 0.5
        }
        TipoPokemon.FUEGO -> {
            if (defensor == TipoPokemon.PLANTA) efectividad = 2.0
            if (defensor == TipoPokemon.AGUA || defensor == TipoPokemon.FUEGO) efectividad = 0.5
        }
        TipoPokemon.PLANTA -> {
            if (defensor == TipoPokemon.AGUA) efectividad = 2.0
            if (defensor == TipoPokemon.FUEGO || defensor == TipoPokemon.PLANTA) efectividad = 0.5
        }
        TipoPokemon.ELECTRICO -> {
            if (defensor == TipoPokemon.AGUA) efectividad = 2.0
            if (defensor == TipoPokemon.PLANTA || defensor == TipoPokemon.ELECTRICO) efectividad = 0.5
        }
    }

    // Mensaje opcional para ver qué pasó
    if (efectividad == 2.0) println("¡Es muy efectivo! (x2)")
    if (efectividad == 0.5) println("No es muy efectivo... (x0.5)")

    return 50 * (ataque / defensa) * efectividad
}