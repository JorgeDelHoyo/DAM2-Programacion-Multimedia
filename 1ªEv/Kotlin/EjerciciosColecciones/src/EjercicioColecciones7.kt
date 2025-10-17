/**
 * Ejercicio 7:
 *  Usando la List de  8 compañeros , recórrela con un bucle for y imprime para cada alumno una frase como:
 *  “El/La alumno/a X está presente.”
 *  Luego, usando el mismo for, imprime los nombres que tienen longitud mayor que 5 caracteres.
 */

fun main() {
    val ochoCompañeros = listOf<String>("Diego","JD","Agustin","Lucia","Jhon","Oscar","Daniel","Zoe")
    for(i in 0 .. ochoCompañeros.size-1){
        println("El/La alumno/a "+ochoCompañeros[i]+" está presente")
        if(ochoCompañeros[i].length > 5){
            println(ochoCompañeros[i]+" tiene longitud mayor que 5\n")
        }
    }

}