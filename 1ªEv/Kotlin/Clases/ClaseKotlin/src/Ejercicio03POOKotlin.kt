/**
 * Modela un sistema de empleados de una empresa.
 * Todos los trabajadores de la empresa realizan las acciones de trabajar y descansar durante su jornada laboral.
 * Además se debe poder calcular el salario que perciben.
 *  * Existen dos tipos de trabajadores: Gerentes , cuyo retribución es el salario base + 20% por ciento.
 *  * Desarrolladores, los cuales perciben el salario base + 10% en su salario.
 *
 * También, todos los trabajadores pueden ser susceptibles de ser evaluados en su desempeño laboral diario.
 * Modela esto último como una interfaz con un metodo que devuelva una cadena con una frase sobre su desempeño.
 * Finalmente crea una lista de trabajadores y recórrela mostrando cada uno de los aspectos señalados en el enunciado.
 */

// Interfaz para evaluación de desempeño
interface Evaluable {
    fun evaluarDesempeño(): String
}

// Clase base Trabajador
open class Trabajador(
    open val nombre: String, open val trabajando: Boolean, protected val salarioBase: Double) : Evaluable {

    open fun trabaja() {
        if (trabajando) {
            println("$nombre está trabajando")
        } else {
            println("$nombre está descansando")
        }
    }

    open fun calcularSalario(): Double {
        return salarioBase
    }

    override fun evaluarDesempeño(): String {
        return "$nombre ha tenido un desempeño general."
    }
}

// Subclase Gerente
class Gerente(override val nombre: String, override val trabajando: Boolean, salarioBase: Double) : Trabajador(nombre, trabajando, salarioBase) {

    override fun calcularSalario(): Double {
        return salarioBase * 1.2
    }

    override fun evaluarDesempeño(): String {
        return "$nombre (Gerente): Excelente capacidad de liderazgo."
    }
}

// Subclase Desarrollador
class Desarrollador(override val nombre: String, override val trabajando: Boolean, salarioBase: Double) : Trabajador(nombre, trabajando, salarioBase) {

    override fun calcularSalario(): Double {
        return salarioBase * 1.1
    }

    override fun evaluarDesempeño(): String {
        return "$nombre (Desarrollador): Buen rendimiento técnico y colaboración en equipo."
    }
}

// Función principal
fun main() {
    val trabajadores: List<Trabajador> = listOf(
        Gerente("Laura", true, 5000.0),
        Desarrollador("Carlos", false, 4000.0),
        Gerente("Andrés", false, 5500.0),
        Desarrollador("Marta", true, 4200.0)
    )

    for (trabajador in trabajadores) {
        trabajador.trabaja()
        println("Salario total: ${trabajador.calcularSalario()}")
        println(trabajador.evaluarDesempeño())
        println("----")
    }
}
