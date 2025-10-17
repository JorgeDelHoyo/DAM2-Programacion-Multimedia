/**
 * Modela un sistema de videojuegos, en el que todos los videojuegos pueden ser iniciados, pausados y terminados.
 * Además se debe calcular la puntuación obtenida en el videojuego en función del tiempo (parámetro entero en segundos)
 * y un parámetro de precisión que indique la habilidad alcanzada por el jugador (campo de tipo Double).
 *
 * Existen además videojuegos multijugador en el que se producen las acciones de unir a la sesión a cada uno de los jugadores,
 * expulsar al jugador, y obtener la lista de jugadores jugando a un juego en un momento dado.
 *
 * La empresa tiene dos tipos de juegos:
 * Juegos de acción que solo pueden ser jugados por un usuario simultáneo y juegos de estrategia, el cual varias personas pueden utilizarlo al mismo tiempo.
 * En estos juegos en el cálculo de de puntuación deberá ser tenido en cuenta el número de jugadores presentes en ese momento en el juego
 */

// Interfaz común para todos los videojuegos
interface Videojuego {
    fun iniciar()
    fun pausar()
    fun terminar()
    fun calcularPuntuacion(tiempo: Int): Double
}

// Interfaz para juegos multijugador
interface Multijugador {
    fun unirJugador(nombre: String)
    fun expulsarJugador(nombre: String)
    fun obtenerJugadores(): List<String>
}

// Clase base con comportamiento común
abstract class VideojuegoBase(protected var precision: Double) : Videojuego {
    protected var estado: String = "detenido"

    override fun iniciar() {
        estado = "iniciado"
        println("Juego iniciado.")
    }

    override fun pausar() {
        estado = "pausado"
        println("Juego pausado.")
    }

    override fun terminar() {
        estado = "terminado"
        println("Juego terminado.")
    }
}

// Juego de acción: solo un jugador
class JuegoAccion(precision: Double) : VideojuegoBase(precision) {

    override fun calcularPuntuacion(tiempo: Int): Double {
        return tiempo * precision
    }
}

// Juego de estrategia: multijugador
class JuegoEstrategia(precision: Double) : VideojuegoBase(precision), Multijugador {

    private val jugadores = mutableListOf<String>()

    override fun unirJugador(nombre: String) {
        jugadores.add(nombre)
        println("$nombre se ha unido al juego.")
    }

    override fun expulsarJugador(nombre: String) {
        if (jugadores.remove(nombre)) {
            println("$nombre ha sido expulsado.")
        } else {
            println("$nombre no está en la lista.")
        }
    }

    override fun obtenerJugadores(): List<String> {
        return jugadores.toList()
    }

    override fun calcularPuntuacion(tiempo: Int): Double {
        val numeroJugadores = jugadores.size.takeIf { it > 0 } ?: 1
        return tiempo * precision * numeroJugadores
    }
}

fun main() {
    val accion = JuegoAccion(precision = 1.2)
    accion.iniciar()
    println("Puntuación (Acción): ${accion.calcularPuntuacion(300)}")
    accion.terminar()

    println("-----")

    val estrategia = JuegoEstrategia(precision = 1.5)
    estrategia.unirJugador("Alice")
    estrategia.unirJugador("Bob")
    estrategia.iniciar()
    println("Jugadores actuales: ${estrategia.obtenerJugadores()}")
    println("Puntuación (Estrategia): ${estrategia.calcularPuntuacion(300)}")
    estrategia.expulsarJugador("Bob")
    println("Jugadores actuales: ${estrategia.obtenerJugadores()}")
    estrategia.terminar()
}

