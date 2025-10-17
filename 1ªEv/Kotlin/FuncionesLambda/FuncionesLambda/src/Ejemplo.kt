/**
 * Ejemplo funcion lambda
 */
fun main() {
    val suma: (Int, Int) -> Int = { x, y -> x + y }
    println(suma(5,6))

    val caudrado : (Int) -> Int = {numero -> numero * numero}
    println(caudrado(3))

    val cuad2 : (Int) -> Int = {it * it}

}