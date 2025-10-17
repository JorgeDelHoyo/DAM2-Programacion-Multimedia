/**
 * Escribe un programa que se encargue de comprobar si un numero es primo.
 * Una vez hecho imprime los numeros primos entre 1 y 100
 */
fun main() {
    println("## PRIMOS ##")
    for(i in 1 until 101) {
        if( esPrimo(i)){
            println(i)
        }
    }
}

/**
 * Funcion para comprobar si un numero es primo
 * @param numero entero a comprobar
 */
fun esPrimo(numero : Int) : Boolean {
    if (numero <= 1) { // Numeros menores o igual a 1 (no primo)
        return false
    }
    if (numero == 2) { // Unico numero primo par
        return true
    }
    if (numero % 2 == 0) { // Si es par y no 2, no es primo
        return false
    }
    // Comprobar divisores impares desde 3 ahasta la raiz cuadrda de numero
    var impares = 3
    while (impares * impares <= numero) {
        if (numero % impares == 0) {
            return false
        }
        impares += 2
    }
    return true
}