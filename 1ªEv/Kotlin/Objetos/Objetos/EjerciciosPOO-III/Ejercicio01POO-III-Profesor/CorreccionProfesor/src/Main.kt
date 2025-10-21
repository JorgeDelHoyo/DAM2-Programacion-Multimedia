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
