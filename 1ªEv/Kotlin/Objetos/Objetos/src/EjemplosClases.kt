/**
 * Objetos -> Configuraciones, datos de conexion
 */
object AppConfig {
    val servidorBBDD : String = "bbddserver"
    val usuarioBBDD : String = "root"

    fun mostrarConexion(){
        println("Debes conectar a $servidorBBDD con el usuario $usuarioBBDD")
    }
}

/**
 * Companion object -> static en Java
 */
class Servidor{
    companion object{
        const val MAXCONEXIOES : Int = 250

        fun mostrarConexionesMaximas(){
            println("Numero maximo de conexiones: $MAXCONEXIOES")
        }
    }
}

/**
 * Data class : Usuario (dni, nombre, edad) ; Producto(id, nombre, stock)
 * 1 - Son final -> No se puede heredar de ellas
 * 2 - necesitan al menos un parametro IP() -> no
 * 3 - toString(), hasCode(), copy(), construct
 */
data class IP(val oct1 : String, val oct2 : String, val oct3 : String, val oct4 : String){
    fun construirIP() : String = oct1+"."+oct2+"."+oct3+"."+oct4
}

/**
 * Sealed class -> abstract -> no puedo crear objetos (solo existen esos subtipos)
 *  -- Restringir la herencia. Figura: circulo, cuadrado
 *  - Manejar estados (exito, error, cargando, en espera)
 */
sealed class IpConfigurable{
    data class ipv4(val cadena : String) : IpConfigurable()
    data class ipv6(val cadena : String) : IpConfigurable()

    fun mostrarTipoIp() : String{
        return when(this){
            is ipv4 -> "Es una ip version 4"
            is ipv6 -> "Es una ip version 6"
        }
    }
}

/**
 * Enum class -> agrupaciones de constantes
 */
enum class nivelesLog{
    DEBUG, INFORMACION, ERROR, CRITICO

}

fun main() {
    AppConfig.mostrarConexion() // objeto
    Servidor.mostrarConexionesMaximas() // Parecido a static, no es necesario crear un objeto

    val ip1 = IP("255","124","52","1")
    println(ip1)
    println(ip1.construirIP())

    val ip2 = ip1.copy(oct1 = "126")
    println(ip2)

    val ipv4 : IpConfigurable = IpConfigurable.ipv4("192.255.0.16")
    val ipv6 : IpConfigurable = IpConfigurable.ipv6("192.255.32.16")
    println(ipv4.mostrarTipoIp())
    println(ipv6.mostrarTipoIp())

    println("Nivel de log por defecto app: ${nivelesLog.INFORMACION}")
}