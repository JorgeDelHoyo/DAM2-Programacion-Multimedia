/**
 * Modela un Sistema de Inventario que haga el seguimiento de Productos , los cuales constan de un id, nombre y precio.
 * El id de los productos es un número secuencial (contador), el cual se va incrementando según se van creando los mismos
 *
 * En el inventario se pueden modelar 3 operaciones:
 * * * Agregar
 * * * Eliminar
 * * * Actualizar los productos.
 * Modela estas operaciones de inventario como una sealed class.
 *
 * Por último , existe un único gestor de Inventario en toda la aplicación,
 * el cual lleva una lista (modelar la lista como Map) en la que se ejecutan las diferentes operaciones sobre los productos
 * (agregar , eliminar y modificar).
 * Además este gestor contiene un metodo para mostrar los productos que actualmente se encuentran dentro del gestor
 *
 * En  el programa principal probar la funcionalidad del gestor agregando , eliminando diferentes productos y mostrar la lista de productos actuales.
 *
 */
<<<<<<< HEAD
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
=======

object Inventario{
    private val listaProductos : MutableMap<Int,Producto> = mutableMapOf<Int,Producto>()

    /**
    fun ejecutarOperaciones(operacion : OperacionesProductos) : Any{
        return when(operacion){
            is OperacionesProductos.Eliminar -> {
                listaProductos.remove(operacion.idprod)

            }
            is OperacionesProductos.Actualizar -> {
                listaProductos[opera]
            }
        }
    }
    */
}
>>>>>>> 0ff627791c977f33edffdd3dbb86f655b08f0256
