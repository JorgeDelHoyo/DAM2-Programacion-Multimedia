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

data class Producto(val id: Int, val nombre: String, val precio: Double) {
    companion object {
        private var contadorId = 0

        fun generarId(): Int = ++contadorId

        fun crear(nombre: String, precio: Double): Producto {
            return Producto(generarId(), nombre, precio)
        }
    }
}