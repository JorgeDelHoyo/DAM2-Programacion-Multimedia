interface AnimalInteface {
    fun reproducirse() {
        println("Creando descendencia...")
    }
}

interface Oviparo : AnimalInteface {
    override fun reproducirse() {
        println("Pongo huevos")
    }
}

interface Mamifero : AnimalInteface {
    override fun reproducirse() {
        println("Mis crias beben leche")
    }
}

class Ornitorrinco : Oviparo, Mamifero {
    override fun reproducirse() {
        super<Oviparo>.reproducirse()
        super<Mamifero>.reproducirse()
    }
}

fun main() {
    val roni: Ornitorrinco = Ornitorrinco()
    roni.reproducirse()
}
