import kotlin.random.Random
/**
 *  Dada una lista de 10 números aleatorios y desordenados, crea una función que verifique si todos los números son positivos.
 */
fun main() {
    val lista = List(10) { Random.nextInt(-10, 11) }
    println("Lista generada: $lista")

    val resultado = todosPositivos(lista)
    println("¿Todos los números son positivos? $resultado")
}

fun todosPositivos(lista : List<Int>) : Boolean{
    return lista.all{it > 0}
}