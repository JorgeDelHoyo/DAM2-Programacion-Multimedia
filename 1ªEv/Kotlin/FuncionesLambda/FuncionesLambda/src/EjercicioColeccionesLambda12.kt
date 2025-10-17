/**
 * Crea una lista en la que se vayan almacenando los 25 primeros números de la secuencia de Fibonacci.
 * Una vez obtenida la lista almacena en un Set aquellos números de la lista anterior que sean primos.
 */
fun main() {
    // Generar los primeros 25 números de la secuencia de Fibonacci
    val listaFibonacci = generarFibonacci(25)

    // Filtrar los números primos de la lista de Fibonacci
    val primosSet = listaFibonacci.filter { esPrimo(it) }.toSet()

    // Imprimir los resultados
    println("Secuencia de Fibonacci (primeros 25 números):")
    println(listaFibonacci)
    println("\nNúmeros primos en la secuencia de Fibonacci:")
    println(primosSet)
}

// Función para generar los primeros 'n' números de Fibonacci
fun generarFibonacci(n: Int): List<Int> {
    val fibonacci = mutableListOf(0, 1) // Empezamos con los dos primeros números
    for (i in 2 until n) {
        fibonacci.add(fibonacci[i - 1] + fibonacci[i - 2])
    }
    return fibonacci
}

// Función para verificar si un número es primo
fun esPrimo(numero: Int): Boolean {
    if (numero <= 1) return false
    for (i in 2..Math.sqrt(numero.toDouble()).toInt()) {
        if (numero % i == 0) return false
    }
    return true
}