/**
 * Escribe un programa que muestre por consola (print) los numeros del 1 al 100
 * sustituyendo los diferentes numeros por las siguientes cadenas
 * - Multiplos de 3 por la palabra "hacker"
 * - Multiplos de 5 por la palabra "matter"
 * - Multiplos de 3 y de 5 a la vez por la palabra "hacker-matter"
 */
fun main() {
    for (i in 1 .. 100) {
        if(i % 3 == 0 && i % 5 == 0) {
            println("hacker")
        }else if(i % 5 == 0) {
            println("matter")
        }else if(i % 3 == 0) {
            println("hacker-matter")
        }else{
            println(i)
        }
    }
}