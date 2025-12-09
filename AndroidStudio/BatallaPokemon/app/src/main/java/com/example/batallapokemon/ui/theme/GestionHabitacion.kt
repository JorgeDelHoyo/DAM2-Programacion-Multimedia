package com.example.batallapokemon.ui.theme

// --- 1. JERARQUÍA DE HABITACIONES ---
// Usamos sealed class porque sabemos que solo existen estos 3 tipos.
sealed class Habitacion(
    val id: Int,
    val numero: Int,
    val precioPorNoche: Double
) {
    // Definimos las subclases específicas
    class Suite(id: Int, numero: Int) : Habitacion(id, numero, 200.0)
    class Doble(id: Int, numero: Int) : Habitacion(id, numero, 100.0)
    class Individual(id: Int, numero: Int) : Habitacion(id, numero, 60.0)

    override fun toString(): String {
        // Un helper para imprimir bonito el nombre de la clase (ej: Suite)
        return "${this::class.simpleName} (Hab: $numero) - $precioPorNoche€/noche"
    }
}

// --- 2. OBJETO RESERVA ---
data class Reserva(
    val habitacion: Habitacion,
    val nombreCliente: String,
    val noches: Int,
    val precioTotal: Double
)

// --- 3. ESTADOS DEL RESULTADO (Sealed Class) ---
// Esto nos permite manejar los 3 resultados posibles de forma segura
sealed class ResultadoReserva {
    data class Confirmada(val reserva: Reserva) : ResultadoReserva()
    data class Rechazada(val motivo: String) : ResultadoReserva()
    object Procesando : ResultadoReserva() // Es un objeto porque no lleva datos extra
}

// --- 4. GESTOR DE RESERVAS (Singleton) ---
object GestorReservas {
    // Lista privada para almacenar las reservas confirmadas
    private val listaReservas = mutableListOf<Reserva>()

    fun realizarReserva(habitacion: Habitacion, nombreCliente: String, noches: Int): ResultadoReserva {
        // Simulamos el estado "Procesando" imprimiendo en consola antes de validar
        println("--- Estado: ${ResultadoReserva.Procesando::class.simpleName} solicitud para $nombreCliente... ---")

        // VALIDACIÓN 1: Número de días mayor que cero
        if (noches <= 0) {
            return ResultadoReserva.Rechazada("El numero de noches debe ser mayor a 0.")
        }

        // VALIDACIÓN 2: Nombre válido (mínimo 3 caracteres)
        if (nombreCliente.trim().length < 3) {
            return ResultadoReserva.Rechazada("El nombre del huesped es demasiado corto.")
        }

        // CÁLCULO: Precio total
        val total = habitacion.precioPorNoche * noches

        // CREACIÓN DE LA RESERVA
        val nuevaReserva = Reserva(habitacion, nombreCliente, noches, total)

        // Guardamos en el historial
        listaReservas.add(nuevaReserva)

        // Retornamos el estado Confirmada
        return ResultadoReserva.Confirmada(nuevaReserva)
    }

    fun mostrarReservas() {
        println("\n=== LISTA DE RESERVAS CONFIRMADAS ===")
        if (listaReservas.isEmpty()) {
            println("No hay reservas activas.")
        } else {
            listaReservas.forEach { res ->
                println("Cliente: ${res.nombreCliente} | Tipo: ${res.habitacion} | Total: ${res.precioTotal}€")
            }
        }
        println("=====================================\n")
    }

    fun cancelarTodas() {
        listaReservas.clear()
        println("Todas las reservas han sido canceladas.")
    }
}

// --- 5. FUNCIÓN PRINCIPAL (MAIN) ---
fun main() {
    // Instanciamos nuestras habitaciones
    val suiteLujo = Habitacion.Suite(1, 101)
    val habDoble = Habitacion.Doble(2, 202)
    val habIndiv = Habitacion.Individual(3, 303)

    println("BIENVENIDO AL SISTEMA DE RESERVAS HOTEL KOTLIN\n")

    // CASO 1: Reserva Correcta (Suite)
    procesarIntento(GestorReservas.realizarReserva(suiteLujo, "Carlos Perez", 3))

    // CASO 2: Error en Noches (0 noches)
    procesarIntento(GestorReservas.realizarReserva(habDoble, "Ana Gomez", 0))

    // CASO 3: Error en Nombre (Corto)
    procesarIntento(GestorReservas.realizarReserva(habIndiv, "Bo", 1))

    // CASO 4: Reserva Correcta (Individual)
    procesarIntento(GestorReservas.realizarReserva(habIndiv, "Lucia M.", 5))

    // Mostrar historial
    GestorReservas.mostrarReservas()

    // Cancelar todo
    GestorReservas.cancelarTodas()
    GestorReservas.mostrarReservas()
}

// Función auxiliar para imprimir el resultado de forma limpia en el Main
fun procesarIntento(resultado: ResultadoReserva) {
    when (resultado) {
        is ResultadoReserva.Confirmada -> {
            println("EXITO: Reserva confirmada para ${resultado.reserva.nombreCliente}. Total a pagar: ${resultado.reserva.precioTotal}€")
        }
        is ResultadoReserva.Rechazada -> {
            println("ERROR: Solicitud rechazada. Motivo: ${resultado.motivo}")
        }
        is ResultadoReserva.Procesando -> {
            println("... Verificando datos ...")
        }
    }
}