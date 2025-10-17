/**
 * Crea una clase Vehículo con propiedades marca y año. Haz una subclase Coche que añada modelo.
 * Crea una lista de coches y muéstralos.
 */
open class Vehiculo(open val marca : String, open val year : Int){
    open fun mostrarDatos(){
        println("\nMarca: $marca \nAño: $year")
    }
}

class Coche(override val marca: String, override val year : Int, val modelo : String) : Vehiculo(marca,year){
    override fun mostrarDatos() {
        println("\nMarca: $marca \nAño: $year \nModelo: $modelo")
    }
}

fun main() {
    val c0 : Coche = Coche("Citroën",2004,"C15")
    val c1 : Coche = Coche("Honda", 2019, "Civic")
    val listaCoches : List<Vehiculo> = listOf(c0,c1)
    for(coches in listaCoches){
        coches.mostrarDatos()
    }
}