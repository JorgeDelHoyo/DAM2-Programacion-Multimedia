/**
 * Modela un sistema de bibliotecas, en la que se pueden prestar, devolver y saber el estado del préstamo de cada uno de los ítems que se encuentran en ella.
 * Solo existen dos tipos de ítems susceptibles de ser prestados:
 * Libros y revistas. Los libros constan de título, autor e isbn. De las revistas se registra el título y la fecha en que fueron publicadas.
 *
 * Crea una lista con varios libros y revistas. Si el ítem se presta se debe eliminar de la lista.
 * En cambio, si se devuelve se deben incluir de nuevo en ella.
 *
 * Recorre la lista de los siguiente modos:
 * * Que únicamente saque los libros que se encuentran en ella.
 * * Que únicamente muestre las revistas de la lista.
 * * Que únicamente muestre los ítems que han sido prestados , ya sean libros y/o revistas.
 *
 */

sealed class ItemBiblioteca {
    abstract val titulo: String
    abstract var prestado: Boolean

    abstract fun prestar()
    abstract fun devolver()

    fun estaPrestado() = prestado
}

data class Libro(override val titulo: String, val autor: String, val ISBN: String, override var prestado: Boolean = false) : ItemBiblioteca() {

    override fun prestar() {
        if (!prestado) {
            prestado = true
            println("El libro '$titulo' ha sido prestado.")
        } else {
            println("El libro '$titulo' ya está prestado.")
        }
    }

    override fun devolver() {
        if (prestado) {
            prestado = false
            println("El libro '$titulo' ha sido devuelto.")
        } else {
            println("El libro '$titulo' no estaba prestado.")
        }
    }
}

data class Revista(override val titulo: String, val fechaPublicacion: String, override var prestado: Boolean = false) : ItemBiblioteca() {

    override fun prestar() {
        if (!prestado) {
            prestado = true
            println("La revista '$titulo' ha sido prestada.")
        } else {
            println("La revista '$titulo' ya está prestada.")
        }
    }

    override fun devolver() {
        if (prestado) {
            prestado = false
            println("La revista '$titulo' ha sido devuelta.")
        } else {
            println("La revista '$titulo' no estaba prestada.")
        }
    }
}

object GestorBiblioteca {
    private val biblioteca = mutableListOf<ItemBiblioteca>()
    private val prestados = mutableListOf<ItemBiblioteca>()

    // Agregar un ítem a la lista principal
    fun agregarItem(item: ItemBiblioteca) {
        biblioteca.add(item)
        println("El ítem '${item.titulo}' ha sido agregado a la biblioteca.")
    }

    // Prestar un ítem (lo mueve de la biblioteca a los prestados)
    fun prestarItem(item: ItemBiblioteca) {
        item.prestar()
        if (item.estaPrestado()) {
            biblioteca.remove(item)
            prestados.add(item)
            println("El ítem '${item.titulo}' ha sido movido a los prestados.")
        }
    }

    // Devolver un ítem (lo mueve de los prestados a la biblioteca)
    fun devolverItem(item: ItemBiblioteca) {
        item.devolver()
        if (!item.estaPrestado()) {
            prestados.remove(item)
            biblioteca.add(item)
            println("El ítem '${item.titulo}' ha sido movido de vuelta a la biblioteca.")
        }
    }

    // Mostrar los libros disponibles en la biblioteca
    fun mostrarLibros() {
        println("Libros en la biblioteca:")
        biblioteca.filterIsInstance<Libro>().forEach {
            println("Título: ${it.titulo}, Autor: ${it.autor}, Prestado: ${it.prestado}")
        }
    }

    // Mostrar las revistas disponibles en la biblioteca
    fun mostrarRevistas() {
        println("Revistas en la biblioteca:")
        biblioteca.filterIsInstance<Revista>().forEach {
            println("Título: ${it.titulo}, Fecha de Publicación: ${it.fechaPublicacion}, Prestado: ${it.prestado}")
        }
    }

    // Mostrar todos los ítems prestados
    fun mostrarPrestados() {
        println("Ítems prestados:")
        prestados.forEach {
            when (it) {
                is Libro -> println("Libro: ${it.titulo}")
                is Revista -> println("Revista: ${it.titulo}")
            }
        }
    }
}

fun main() {
    // Crear algunos ítems
    val libro1 = Libro("El Quijote", "Miguel de Cervantes", "12345")
    val libro2 = Libro("Cien años de soledad", "Gabriel García Márquez", "67890")
    val revista1 = Revista("National Geographic", "Enero 2023")
    val revista2 = Revista("Time", "Febrero 2023")

    // Agregar los ítems a la biblioteca
    GestorBiblioteca.agregarItem(libro1)
    GestorBiblioteca.agregarItem(libro2)
    GestorBiblioteca.agregarItem(revista1)
    GestorBiblioteca.agregarItem(revista2)

    // Prestar algunos ítems
    GestorBiblioteca.prestarItem(libro1)
    GestorBiblioteca.prestarItem(revista1)

    // Mostrar la información
    GestorBiblioteca.mostrarLibros()
    GestorBiblioteca.mostrarRevistas()
    GestorBiblioteca.mostrarPrestados()

    // Devolver ítems
    GestorBiblioteca.devolverItem(libro1)
    GestorBiblioteca.devolverItem(revista1)

    // Volver a mostrar la información
    println("\nDespués de devolver los ítems:")
    GestorBiblioteca.mostrarLibros()
    GestorBiblioteca.mostrarRevistas()
    GestorBiblioteca.mostrarPrestados()
}
