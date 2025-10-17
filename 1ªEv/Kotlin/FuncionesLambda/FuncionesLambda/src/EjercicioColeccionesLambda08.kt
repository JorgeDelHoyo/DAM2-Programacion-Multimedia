/**
 *  Dada una lista con los nombres de 8 de tus compañeros.
 *  Crea una función que agrupe los nombres por la longitud de las cadenas.
 */
fun main() {
    val nombresClase = listOf<String>("JD", "Diego", "Agustin", "Lucia", "Jhon", "Oscar", "Dani", "Zoe")
    // Llamamos a la función que agrupa los nombres por longitud
    val agrupadosPorLongitud = agruparPorLongitud(nombresClase)

    // Imprimimos el resultado
    println(agrupadosPorLongitud)
}
fun agruparPorLongitud(lista : List<String>) : Map<Int, List<String>>{
    return lista.groupBy { it.length }
}