
abstract class Vehiculo(){
    var estadoConservacion : String = ""

    abstract fun arrancar() // Se debe implementar en las subClases
}

class Coche(val marca : String) : Vehiculo() {

    // No se puede reasignar una variable de la clase abstracta ( hay que inicializarla)
    init {
        estadoConservacion = "Bueno"
    }

    override fun arrancar() {
        println("ARRANCA")
    }

    class Motor (val cilindrada : Double){
        fun mostrarCilindrada(){
            println("Marca con cilindrada $cilindrada")
        }
    } // Class motor

    inner class Asiento(){
        var material : String = ""
        fun mostrarMaterialAsiento() {

            when (marca) {
                "ford" -> material = "nilon"
                "seat" -> material = "poliester"
                "audi" -> material = "cuero"
            }
            println("Marca $marca con asientos de material $material")
        }
    }// Class Asiento
}// Class coche

fun main() {
    val motor = Coche.Motor(2.3)
    val coche1 = Coche("audi")
    coche1.Asiento().mostrarMaterialAsiento()

    println("Estado de conservacion")
    coche1.estadoConservacion
}