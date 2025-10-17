/**
 * Modela un sistema de notificaciones como una clase abstracta.
 * El sistema de notificaciones debe ser capaz de enviar un mensaje tecleado (enviado como parámetro).
 * Además tiene una función de obtener información del mensaje el cual devuelve una cadena de texto con el propio mensaje y la longitud del mismo.
 * Mediante este sistema se pueden enviar dos tipos de mensajes: Mensajes de correo electrónico,el cual contiene un emisor,
 * un receptor (ambas direcciones de email), y cuya longitud máxima del mensaje es de 1500 caracteres.
 *
 * También se pueden enviar mensajes de Whatsapp, en el que se necesita el número del teléfono del destinatario y la cantidad máxima de caracteres a enviar es de 600.
 * El sistema de notificaciones se implementará en la función principal (main) y en el se podrán:
 * * Agregar las notificaciones a una cola de notificaciones.
 *  * Enviar todas las notificaciones (sean del tipo que sean)
 *  * Contar (y mostrar) el tipo de notificaciones existentes: Ejemplo 4 notificaciones de correo electronico , 5 notificaciones de Whatsapp
 */

/**
 * Clase abstracta que envia un mensaje y muestra el mensaje mediante la funcion
 */
abstract class Notificacion(){
    abstract fun enviar(mensaje : String)
    val longitudMensaje : Int = 0
    fun obtenerInformacionMensaje(mensaje : String) : String{
        return "Mensaje: $mensaje \nLongitud: ${mensaje.length}."
    }
}

class CorreoElectronico(val emisor : String, val receptor : String) : Notificacion() {

    init {
        val longitudMensaje : Int = 1500
    }

    override fun enviar(mensaje: String) {
        if(mensaje.length > longitudMensaje){
            println("Mensaje demasiado largo, maximo 1500 caracteres")
        }else{
            println("Mensaje de $emisor enviado a $receptor")
            println(obtenerInformacionMensaje(mensaje))
        }
    }
}

class WhatsApp(val telefono : String) : Notificacion(){

    init {
        val longitudMensaje : Int = 600
    }

    override fun enviar(mensaje: String) {
        if(mensaje.length > longitudMensaje){
            println("Mensaje demasiado largo, maximo 600 caracteres")
        }else{
            println("Mensaje enviado a $telefono")
            println(obtenerInformacionMensaje(mensaje))
        }
    }
}

fun main() {

    val colaDeNotificaciones = mutableListOf<Pair<Notificacion, String>>()

    // Agregamos notificaciones
    colaDeNotificaciones.add( CorreoElectronico("juan@correo.com","maria@correo.com") to "Hola María, este es un mensaje de prueba por correo.")
    colaDeNotificaciones.add(WhatsApp("123456789") to "Hola, este es un mensaje corto por WhatsApp.")
    colaDeNotificaciones.add(
        CorreoElectronico(
            "admin@empresa.com",
            "soporte@empresa.com"
        ) to "Reporte del sistema, todo funciona correctamente."
    )
    colaDeNotificaciones.add(
        WhatsApp("987654321") to "Mensaje rápido por WhatsApp para confirmar reunión."
    )
    // Enviar todas las notificaciones
    println("=== ENVIANDO TODAS LAS NOTIFICACIONES ===")
    for ((notificacion, mensaje) in colaDeNotificaciones) {
        notificacion.enviar(mensaje)
        println()
    }

    // Contar tipos de notificaciones
    val conteo = colaDeNotificaciones.groupingBy { it.first::class.simpleName }.eachCount()

    println("=== RESUMEN DE NOTIFICACIONES ===")
    conteo.forEach { (tipo, cantidad) ->
        val tipoLegible = when (tipo) {
            "CorreoElectronico" -> "notificaciones de correo electrónico"
            "Whatsapp" -> "notificaciones de WhatsApp"
            else -> "notificaciones desconocidas"
        }
        println("$cantidad $tipoLegible")
    }
}
