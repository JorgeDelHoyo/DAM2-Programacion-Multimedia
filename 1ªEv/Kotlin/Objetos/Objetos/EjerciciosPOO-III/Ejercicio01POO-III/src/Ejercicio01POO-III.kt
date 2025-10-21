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

fun main() {

    // Agregar productos
    GestorInventario.ejecutarOperacion(Inventario.Agregar("Teclado", 45.0))
    GestorInventario.ejecutarOperacion(Inventario.Agregar("Monitor", 299.99))
    GestorInventario.ejecutarOperacion(Inventario.Agregar("Mouse", 25.0))

    // Mostrar productos
    GestorInventario.mostrarInventario()

    // Actualizar producto con ID 2
    GestorInventario.ejecutarOperacion(Inventario.Actualizar(2, "Monitor HD", 279.99))

    // Eliminar producto con ID 1
    GestorInventario.ejecutarOperacion(Inventario.Eliminar(1))

    // Mostrar productos nuevamente
    GestorInventario.mostrarInventario()
}