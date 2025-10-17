/**
 * Crea una Lista inmutable llamada alumnos que contenga todos los nombres de tus compañeros.
 * Imprime el tamaño de la lista. Luego imprime el elemento en la posición 2 y posición 5, usando tanto la posición [] como utilizando get().
 */
fun main() {
    val compañeros = arrayListOf<String>("Agustin", "JD", "Diego", "Daniel","Lucia", "Jhon","Oscar","Zoe")
    println(compañeros.size)
    println(compañeros[2])
    println(compañeros.get(5))
}