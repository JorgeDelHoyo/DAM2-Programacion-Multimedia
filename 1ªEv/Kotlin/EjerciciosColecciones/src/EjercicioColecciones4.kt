/**
 * Crea una  Lista Mutable llamada grupo con 3 nombres de tus compañeros
 * Agrega al final de la lista: Francisco y Blanca
 *
 * Inserta “Maria Isabel” en la posición 2
 *
 * Cambia el nombre en el índice 3 por “Felix”.
 *
 * Quita el nombre “Jorge”.
 *
 * Comprueba si “Adela” está en la lista (usando el operador in).
 *  Imprime la lista completa tras cada operación (o al final).
 */
fun main() {
    var grupo = mutableListOf<String>("Diego","Agustin","JD")
    grupo.add("Francisco")
    grupo.add("Blanca")
    println(grupo)
    grupo.add(2,"Maria Isabel")
    grupo.set(3, "Felix")
    grupo.remove("Jorge")

    if("Adela" in grupo){
        println("Adela existe")
    }else{
        println("Adela no existe")
    }
    for(i in 0 .. grupo.size-1){
        println(grupo[i])
    }
}