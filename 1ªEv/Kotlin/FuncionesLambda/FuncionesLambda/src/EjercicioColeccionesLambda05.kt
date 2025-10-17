/**
 * Dada una lista de 20 números tanto negativos como positivos.
 * Crea una función que verifique si al menos uno de los elementos es negativo.
 */
fun main() {
    val lista = listOf<Int>(1,2,3,4,5,6,-7,8,9,-10,11,12,13,14,15,16,17,18,19,20)
    val resultado = existeNegativo(lista)
    println("¿Hay algún número negativo? -> $resultado")
}
fun existeNegativo(lista : List<Int>) : Boolean{
    return lista.any(){it < 0} // Devuelve true si al menos un número es negativo
}