
//FORMA KOTLIN (open -> sobreescribir)
open class Persona (val nombre : String){
    open fun presentacion(){
        println("Me llamo $nombre")
    }
}

class Trabajadorr(nombre : String, val nif : String) : Persona(nombre){
    override fun presentacion(){
        println("soy $nombre con NIF $nif")
    }
}

fun main() {
    val p: Persona = Persona("Pedro")
    p.presentacion()
    val t: Trabajadorr = Trabajadorr("Pedro", "54382610U")
}