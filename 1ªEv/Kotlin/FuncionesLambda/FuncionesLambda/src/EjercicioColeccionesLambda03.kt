/**
 * Dada una lista de 15 enteros, crea una función que calcule la suma total de los elementos de la lista
 */
fun main() {
    val lista = listOf<Int>(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    val resultado = sumaTotal(lista)
    println(resultado)

}
fun sumaTotal(lista : List<Int>) : Int{
    var sumatorio : Int = 0
    for (i in 0 .. lista.size-1){
        sumatorio += lista[i]
    }
    return sumatorio
}

fun sumaNumeros(numeros : List<Int>) : Int{
    // acc (acumulador) + it (Iterador)
    return numeros.reduce { acc, it -> acc + it }
}