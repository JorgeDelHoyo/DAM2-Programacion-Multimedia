/**
 * Ejemplos para uso basico de Kotlin
 */
fun main() {

    println("adoro kotlin")
    val nombre: String = "Maria" // Inmutable
    var apellido: String = "Perez" // Mutable
    val edad: Int = 25
    // nombre = "Pedro"

    println(nombre)
    println("Su nombre es $nombre")
    println("Su edade es ${edad + 10}")

    // nullSafety -> tipo"?"
    var apellido2: String? = null
    // Si es nulo el objeto referenciado da valor "0"
    var longitud = apellido2?.length ?: 0
    println("Longitud de tu apellido $longitud")

    // _____________________________________________ //

    val oper1: Int = 5
    val oper2: Int = 7
    // var resultado : Int = suma(oper1,oper2)

    println("La suma es ${suma(oper1, oper2)}")
    // println("La suma es $resultado")
}

/**
 * Funcion suma con sus parametros a y b
 */
fun suma(a: Int, b: Int): Int {
    return a + b
}