/**
 * Modela un Sistema de Inventario que haga el seguimiento de Productos , los cuales constan de un id, nombre y precio.
 * El id de los productos es un número secuencial (contador), el cual se va incrementando según se van creando los mismos
 *
 * En el inventario se pueden modelar 3 operaciones: Agregar , eliminar y actualizar los productos.
 * Modela estas operaciones de inventario como una sealed class.
 *
 * Por último , existe un único gestor de Inventario en toda la aplicación, el cual lleva una lista
 * (modelar la lista como Map) en la que se ejecutan las diferentes operaciones sobre los productos (agregar , eliminar y modificar).
 * Además este gestor contiene un matodo para mostrar los productos que actualmente se encuentran dentro del gestor
 *
 * En  el programa principal probar la funcionalidad del gestor agregando,
 * eliminando diferentes productos y mostrar la lista de productos actuales.
 *
 */
data class Producto(val id : Int, val nombre : String, val precio : Double){

    //ID Incremental
    companion object{
        private var contadorId : Int = 0

        fun crear(nombre : String, precio: Double): Producto{
            contadorId++
            return Producto(contadorId, nombre, precio)
        }
    }
}

sealed class OperacionesInventario{
    data class Agregar(val nombre : String, val precio: Double) : OperacionesInventario()
    data class Eliminar(val id: Int) : OperacionesInventario()
    data class Actualizar(val id: Int, val nombre: String, val precio: Double) : OperacionesInventario()
}

object GestorInventario{

    val listaProductos : MutableMap<Int,Producto> = mutableMapOf()

    fun ejecutarOperaciones(operacion : OperacionesInventario){
        when(operacion){
            is OperacionesInventario.Agregar -> {
                val producto = Producto.crear(operacion.nombre,operacion.precio)
                listaProductos[producto.id] = producto
                println("${producto.nombre} agregado correctamente")
            }
            is OperacionesInventario.Eliminar -> {
                val eliminado = listaProductos.remove(operacion.id)
                if(eliminado != null){
                    println("${eliminado.id} eliminado correctamente")
                }else{
                    println("${operacion.id} no encontrado")
                }
            }
            is OperacionesInventario.Actualizar -> {
                val productoActual = listaProductos[operacion.id]
                if(productoActual != null){
                    val actualizado = productoActual.copy(nombre = operacion.nombre, precio = operacion.precio)
                    listaProductos[operacion.id] = actualizado
                    println("${actualizado.nombre} actualizado correctamente")
                }else{
                    println("${operacion.id} no encontrado")
                }
            }
        }
    }

    fun mostrarInventario(){
        if(listaProductos.isEmpty()){
            println("El inventario está vacio")
        }else{
            println("\n====== Productos ======")
            listaProductos.forEach { println(it) }
        }
    }
}

fun main() {
    GestorInventario.ejecutarOperaciones(OperacionesInventario.Agregar("Teclado",45.00))
    GestorInventario.ejecutarOperaciones(OperacionesInventario.Agregar("Monitor", 299.99))
    GestorInventario.ejecutarOperaciones(OperacionesInventario.Agregar("Mouse", 25.0))

    GestorInventario.mostrarInventario()

    GestorInventario.ejecutarOperaciones(OperacionesInventario.Actualizar(2, "Monitor HD", 279.99))

    GestorInventario.ejecutarOperaciones(OperacionesInventario.Eliminar(1))

    GestorInventario.mostrarInventario()

    GestorInventario.ejecutarOperaciones(OperacionesInventario.Agregar("Teclado Ryzen",70.00))

    GestorInventario.mostrarInventario()
}
