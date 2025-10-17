/**
 *  Dada una lista de enteros, crea una función que calcule la multiplicación total de todos los elementos de la lista
 */
fun main() {
    val lista = listOf<Int>(2,2,2)
    val resultado = multiplicaTodo(lista)
    println(resultado)
}
fun multiplicaTodo(lista : List<Int>) : Int{
    var multiplicador : Int = 1
    for (i in 0 .. lista.size-1){
        multiplicador *= lista[i]
    }
    return multiplicador
}
