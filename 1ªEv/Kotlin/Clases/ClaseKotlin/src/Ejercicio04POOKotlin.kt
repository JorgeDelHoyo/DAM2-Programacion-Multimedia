import java.util.Objects

/**
 * Modela un sistema de bibliotecas, en la que se pueden prestar , devolver y saber el estado del préstamo de cada uno de los ítems que se encuentran en ella.
 * Solo existen dos tipos de ítems susceptibles de ser prestados: Libros y revistas.
 * Los libros constan de título, autor e isbn. De las revistas se registra el título y la fecha en que fueron publicadas.
 * Crea una lista con varios libros y revistas. Si el ítem se presta se debe eliminar de la lista. En cambio, si se devuelve se deben incluir de nuevo en ella.
 * Recorre la lista de los siguiente modos:
 * Que únicamente saque los libros que se encuentran en ella.
 * Que únicamente muestre las revistas de la lista.
 * Que únicamente muestre los ítems que han sido prestados , ya sean libros y/o revistas.
 */

// Interfaz para ítems prestables
interface Prestable {
    fun prestar()
    fun devolver()
    fun estaPrestado(): Boolean
}

// Clase Libro
class Libro(val titulo: String, val autor: String, val isbn: String) : Prestable {
    var prestado = false

    override fun prestar() {
        prestado = true
    }

    override fun devolver() {
        prestado = false
    }

    override fun estaPrestado(): Boolean = prestado

    override fun toString(): String {
        return "Libro(titulo='$titulo', autor='$autor', isbn='$isbn')"
    }
}

class Revista(val titulo: String, val fechaPublicacion: String) : Prestable{
    var prestado = false

    override fun prestar() {
        prestado = true
    }

    override fun devolver() {
        prestado = false
    }

    override fun estaPrestado(): Boolean = prestado

    override fun toString(): String {
        return "Revista(titulo='$titulo', fechaPublicacion='$fechaPublicacion')"
    }
}

fun main() {

    var libro1 : Libro = Libro("A","Aa", "1234AA")
    var libro2 : Libro = Libro("B","Bb", "1234BB")
    var libro3 : Libro = Libro("C","Cc", "1234CC")

    // val listaLibros : List<Libro> = listOf(libro1, libro2, libro3)

    var revista1 : Revista = Revista("Ra","123")
    var revista2 : Revista = Revista("Rb","235")
    var revista3 : Revista = Revista("Rc","347")


    var listaItems = mutableListOf(libro1, libro2, revista1, revista2)

    var itemsPrestados : MutableList<Prestable> = mutableListOf<Prestable>()

    libro1 = listaItems.get(0) as Libro
    libro1.prestar()
    itemsPrestados.add(libro1)

    revista1 = listaItems.get(2) as Revista
    revista1.prestar()
    itemsPrestados.add(revista1)

    libro1.devolver()
    revista1.devolver()
    listaItems.add(libro1)
    listaItems.add(revista1)
    itemsPrestados.remove(libro1)
    itemsPrestados.remove(revista1)


    println("LIBROS DISPONIBLES\n")
    listaItems.filterIsInstance<Libro>().forEach { println(it.titulo) }
    println("REVISTAS DISPONIBLES\n")
    listaItems.filterIsInstance<Revista>().forEach { println(it.titulo) }

    println("LIBROS PRESTADOS\n")
    itemsPrestados.forEach { println(it.toString()) }

}