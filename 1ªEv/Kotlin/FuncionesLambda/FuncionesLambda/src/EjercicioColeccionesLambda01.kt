/**
 * Dada una lista de 10 enteros.
 * Crea una función que devuelva una lista con el doble de cada número.
 */
fun main() {
    val lista = listOf<Int>(0,1,2,3,4,5,6,7,8,9)
    val resultado = doble(lista)
    println(resultado)
}

fun doble(lista : List<Int>) : List<Int>{
    return lista.map { it * 2 }
}