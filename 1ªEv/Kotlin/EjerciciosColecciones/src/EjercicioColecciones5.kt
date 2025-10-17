/**
 * Crea un MutableSet llamado ConjuntoClase con 4 nombres de compañeros
 * Imprime su tamaño.
 *
 * Agrega a “Blanca”.
 *
 * Agrega a “Lucía” otra vez (nombre repetido).
 *
 * Imprime el tamaño de nuevo.
 *
 * Quita a Diego.
 *
 * Comprueba si “Esmeralda” está en el conjunto.
 *  Imprime el conjunto y los resultados de tamaño y existencia.
 */

fun main() {
    val conjuntoClase = mutableSetOf<String>("Diego","Agustin","JD","Lucia")
    println("Tamaño: "+conjuntoClase.size)
    conjuntoClase.add("Blanca")
    conjuntoClase.add("Lucia")
    println("Tamaño: "+conjuntoClase.size)
    conjuntoClase.remove("Diego")
    if("Esmeralda" in conjuntoClase){
        println("Esmeralda está")
    }else{
        println("Esmeralda no está")
    }

    println(conjuntoClase)
}