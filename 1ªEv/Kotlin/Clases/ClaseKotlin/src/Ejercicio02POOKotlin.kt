/**
 * Crea una interfaz Reproducible con una función reproducir().
 * Implementa la interfaz en dos clases: Película y Canción, con comportamientos distintos.
 */

interface Reproducible{
    fun reproducir(){
        println("Me reproduzco")
    }
}
class Pelicula() : Reproducible{
    override fun reproducir() {
        println("Reproduzco una pelicula")
    }
}
class Cancion() : Reproducible{
    override fun reproducir() {
        println("Reproduzco una cancion")
    }
}

fun main() {
    val pelicula : Pelicula = Pelicula()
    pelicula.reproducir()
    val cancion : Cancion = Cancion()
    cancion.reproducir()
}