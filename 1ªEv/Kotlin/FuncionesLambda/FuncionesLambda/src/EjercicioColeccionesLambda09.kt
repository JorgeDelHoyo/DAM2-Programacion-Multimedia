
/**
 *  Dada una lista de 20 números aleatorios y desordenados.
 *  Crea una función que divida la lista en dos grupos: los números pares y los impares.
 */
import kotlin.random.Random

fun main() {
    // Generamos una lista de 20 números aleatorios entre -100 y 100
    val lista = List(20) { Random.nextInt(-100, 101) }
    println("Lista generada: $lista")

    // Llamamos a la función para dividir la lista en pares e impares
    val (pares, impares) = dividirParesEImpares(lista)

    // Imprimimos los resultados
    println("Números pares: $pares")
    println("Números impares: $impares")
}

fun dividirParesEImpares(lista: List<Int>): Pair<List<Int>, List<Int>> {
    // Usamos partition() para dividir la lista en dos grupos: pares e impares
    return lista.partition { it % 2 == 0 }
}
