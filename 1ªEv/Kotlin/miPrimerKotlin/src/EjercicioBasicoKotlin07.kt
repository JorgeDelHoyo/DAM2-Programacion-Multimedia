/**
 * Desarrolla un programa que realice lo siguiente, dada una edad:
 * - Si la edad es menor que 18 muestre por pantalla "Eres menor de edad"
 * - Si la edad es igual a 18: "Ya eres mayor de edad!"
 * - Si la edad es mayor a 18: "Enhorabuena, ya puedes votar!"
 * Debes verificar que la edad introducida sea positiva o en caso contrario mostrar error
 */
fun main() {
    val edad : Int = 16
    println(comprobarEdad(edad))
}

/**
 * Funcion para comprobar la edad
 */
fun comprobarEdad(edad: Int){
    if (edad < 0) {
        println("ERROR")
    }
    if (edad < 18 && edad >= 0) {
        println("Eres menor de edad")
    }
    if (edad == 18) {
        println("Ya eres mayor de edad!")
    }
    if (edad > 18) {
        println("Enhorabuena, ya puedes votar!")
    }
}