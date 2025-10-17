/**
 * Crea un array de nombre DAM2 con los nombres de 4 de tus compañeros de clase.
 * Luego crea otro array  llamado 2DAM con el nombre de otros 4 compañeros Luego une ambos arrays en un nuevo array llamado claseCompleta.
 * Imprime todos los nombres uno por uno usando los índices de los elementos.
 */

fun main() {
    val arrayClase = arrayOf<String>("Agustin", "JD", "Diego", "Daniel")
    val dam2 = arrayOf<String>("Lucia", "Jhon","Oscar","Zoe")
    val claseCompleta = arrayClase + dam2

    println(claseCompleta.indices)
    for(i in claseCompleta.indices){
        println("elemento $i con valor ${claseCompleta[i]}")
    }
}