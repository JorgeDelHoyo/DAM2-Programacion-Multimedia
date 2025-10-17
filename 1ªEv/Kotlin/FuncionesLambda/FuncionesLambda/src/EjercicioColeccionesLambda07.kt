import kotlin.random.Random

/**
 *  Dada una lista de números aleatorios y desordenados, crea una función que devuelva el primer número mayor que 4.
 *  Si no existe ninguno  devuelve un valor nulo.
 */
fun main() {
    val lista = List(10) {Random.nextInt(-10, 11)}
    println("Lista generada: $lista")

    val resultado = numeroMayor4(lista)
    println("El primer número mayor que 4 es: $resultado")
}

fun numeroMayor4(lista : List<Int>) : Int?{
    // Buscamos el primer numero mayor que 4 en la lista
    return lista.find { it > 4 }
}