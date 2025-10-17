/**
 * Crea un programa que invierta el orden de una cadena de texto sin
 * usar funciones propias del lenguaje que lo haga automáticamente
 * Ejemplo: Si le pasamos "VivaKotlin" nos retornaría "niltoK aviV"
 */

fun main() {
    val ejemplo = "Viva Kotlin"
    val resultado = reversa(ejemplo)
    println("Original : $ejemplo")
    println("Invertida: $resultado")
}

/**
 * Funcion que da vuelta a la palabra
 * @param texto que será dado la vuelta
 */
fun reversa(texto : String) : String {
    var reversa : String = "" // String Vacio para construir la reversa
    // Desde el final de la palabra hasta el principio
    for(i in texto.length -1 downTo 0) {
        // Añadimos el final de la palabra al principio de la reversa
        reversa += texto[i]
    }
    return reversa
}