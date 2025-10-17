/**
 * Usando el array claseCompleta del ejercicio anterior, cambia el nombre del alumno en el índice 3 por “Nacho”.
 * Luego imprime el nombre en esa posición para verificar el cambio.
 */
fun main() {
    val arrayClase = arrayOf<String>("Agustin", "JD", "Diego", "Jorge")
    val dam2 = arrayOf<String>("Lucia", "Jhon","Oscar","Zoe")
    val claseCompleta = arrayClase + dam2

    claseCompleta[3] = "Nacho";

    print(claseCompleta[3])
}