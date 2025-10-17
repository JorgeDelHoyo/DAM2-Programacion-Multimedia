/**
 * Crea un programa que se encargue de transformar un numero decimal a binario
 * sin utilizar funciones propias del lenguaje
 */
fun main() {
    val decimal = 25
    val resultado = convertirBinario(decimal)
    println("Decimal: $decimal")
    println("Binario: $resultado")
}

/**
 * Funcion para convertir a binario
 */
fun convertirBinario(decimal : Int) : String {
    if (decimal == 0) {
        return "0"
    }
    var n = decimal
    var binario = ""

    while (n > 0) {
        val resto = n % 2 // Sacar resto (0-1)
        binario = resto.toString() + binario // Añadirlo
         n /= 2 // Dividir entre 2
    }
    return binario

    
}