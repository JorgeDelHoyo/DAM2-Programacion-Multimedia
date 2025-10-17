class Pieza (val id : String, var stock : Int) {
    init {
        require(id.isNotEmpty()){"Id de Pieza no valido"}
        println("Creando pieza con id $id y stock $stock")
    }
    constructor(id : String) : this(id, 0)

    constructor(id: String, stock: Int, ancho: Double) : this(id, stock)
    
    fun mostrarInfoPieza(){
        println("Pieza con la siguiente información: $id y cantidad: $stock")
    }
}

fun main() {
    val p : Pieza = Pieza("AWIWI", 56) // Constructor principal
    p.mostrarInfoPieza()
    val p2 : Pieza = Pieza("XYZ") // Constructor secundario
    p2.mostrarInfoPieza()

    val p3 : Pieza = Pieza("")
}