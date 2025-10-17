/**
 * Dada una lista de personas (con propiedades nombre y edad).
 * Crea una función que ordene las personas por edad de menor a mayor.
 *
 * Nota: Para crear un objeto de tipo Persona escribe lo siguiente:
 * data class Persona(val nombre: String, val edad: Int)
 * La lista que crees de este tipo , en vez de ser Int o String será del tipo Persona
 */
fun main() {
    data class Persona(val nombre: String, val edad: Int)
    val listaPersonas = listOf(
        Persona("Carlos", 25),
        Persona("Ana", 30),
        Persona("Luis", 22),
        Persona("Sofia", 19),
        Persona("Javier", 35),
        Persona("Beatriz", 28),
        Persona("Fernando", 24),
        Persona("María", 18)
    )
    val listaOrdenada = listaPersonas.sortedBy { it.edad }

    println("Lista de personas ordenada por edad: ")
    listaOrdenada.forEach { persona -> println("${persona.nombre} - ${persona.edad} años") }
}