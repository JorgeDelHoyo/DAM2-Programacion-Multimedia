package productos_Autenticacion.productos
data class Producto(val id: Int, val nombre: String, val precio: Double) {
    companion object {
        private var contadorId = 0

        fun generarId(): Int = ++contadorId

        fun crear(nombre: String, precio: Double): Producto {
            return Producto(generarId(), nombre, precio)
        }
    }
}

sealed class OperacionInventario {
    data class Agregar(val producto: Producto) : OperacionInventario()
    data class Eliminar(val id: Int) : OperacionInventario()
    data class Actualizar(val id: Int, val nuevoPrecio: Double) : OperacionInventario()
}

object GestorInventario {
    private val inventario = mutableMapOf<Int, Producto>()

    fun ejecutarOperacion(op: OperacionInventario): String {
        return when (op) {
            is OperacionInventario.Agregar -> {
                inventario[op.producto.id] = op.producto
                "Producto agregado: ${op.producto.nombre}"
            }
            is OperacionInventario.Eliminar -> {
                val eliminado = inventario.remove(op.id)
                if (eliminado != null) "Producto eliminado: ${eliminado.nombre}"
                else "Producto no encontrado"
            }
                    is OperacionInventario.Actualizar -> {
                val producto = inventario[op.id]
                if (producto != null) {
                    inventario[op.id] = producto.copy(precio = op.nuevoPrecio)
                    "Precio actualizado a ${op.nuevoPrecio}€"
                } else "Producto no encontrado"
            }
        }
    }

    fun mostrarInventario() {
        println("=== INVENTARIO ===")
        inventario.forEach { (_, prod) ->
            println("ID: ${prod.id}, ${prod.nombre} - ${prod.precio}€")
        }
    }
}


fun main() {
    val prod1 = Producto.crear("Laptop", 899.99)
    val prod2 = Producto.crear("Mouse", 25.50)
    val prod3 = Producto.crear("Teclado", 75.00)

    println(GestorInventario.ejecutarOperacion(OperacionInventario.Agregar(prod1)))
    println(GestorInventario.ejecutarOperacion(OperacionInventario.Agregar(prod2)))
    println(GestorInventario.ejecutarOperacion(OperacionInventario.Agregar(prod3)))

    GestorInventario.mostrarInventario()

    println("\n" + GestorInventario.ejecutarOperacion(OperacionInventario.Actualizar(2, 29.99)))
    println(GestorInventario.ejecutarOperacion(OperacionInventario.Eliminar(3)))

    GestorInventario.mostrarInventario()
}