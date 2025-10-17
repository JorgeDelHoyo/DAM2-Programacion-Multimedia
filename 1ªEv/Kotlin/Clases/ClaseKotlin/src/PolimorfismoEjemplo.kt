open class Animal(){
    open fun hacerSonido(){
        println("No se que animal soy")
    }
}

// Sin paréntesis (Animal()) es Interfaz
class Pajaro() : Animal(){
    override fun hacerSonido() {
        println("PIO PIO")
    }
}

class Perro() : Animal(){
    override fun hacerSonido() {
        println("GUAU GUAU")
    }
}

fun main(){
    val listaAnimales : List<Animal> = listOf(Pajaro(), Perro(), Animal())
    for(animal in listaAnimales){
        animal.hacerSonido()
    }

    // Otra forma recorrer listas
    listaAnimales.forEach { println(it.hacerSonido()) }
}