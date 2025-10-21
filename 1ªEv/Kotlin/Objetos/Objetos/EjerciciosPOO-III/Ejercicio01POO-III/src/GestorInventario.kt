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

object GestorInventario{

    // Mapa mutable de objetos productos
    val productos : MutableMap<Int, Producto> = mutableMapOf()

    // Metodo que ejecuta todas las operaciones del inventario
    fun ejecutarOperacion(operacion : Inventario){
        when(operacion){
            // Funcion de agregar en inventario
            is Inventario.Agregar -> {
                val producto = Producto.crear(operacion.nombre,operacion.precio)
                productos[producto.ID] = producto
                println("\n$producto --> agregado correctamente")
            }
            // Funcion de eliminar en inventario
            is Inventario.Eliminar -> {
                val eliminado = productos.remove(operacion.id)
                if(eliminado != null){
                    println("\n${eliminado.nombre} --> eliminado correctamente")
                }else{
                    println("\n${operacion.id} --> no encontrado")
                }
            }
            // Funcion para actualizar un objeto del inventario
            is Inventario.Actualizar -> {
                val productoActual = productos[operacion.id]
                if(productoActual != null){
                    // Copia para no modificar el objeto referenciado
                    val actualizado = productoActual.copy(nombre = operacion.nuevoNombre, precio = operacion.nuevoPrecio)
                    productos[operacion.id] = actualizado // Asignamos el mismo id
                    println("\n$actualizado --> actualizado correctamente")
                }else{
                    println("\n${operacion.id} --> no encontrado")
                }
            }
        }
    }

    fun mostrarInventario(){
        if(productos.isEmpty()){
            println("El inventario está vacio")
        }else{
            println("\n====== Productos ====== ")
            productos.forEach { println(it) }
        }
    }
}