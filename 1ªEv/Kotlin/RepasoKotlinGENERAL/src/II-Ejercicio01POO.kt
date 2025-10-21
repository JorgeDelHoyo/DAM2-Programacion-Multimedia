/**
 * Modela un sistema de notificaciones como una clase abstracta.
 * El sistema de notificaciones debe ser capaz de enviar un mensaje tecleado (enviado como parámetro).
 * Además tiene una función de obtener información del mensaje el cual devuelve una cadena de texto
 * con el propio mensaje y la longitud del mismo.
 *
 * Mediante este sistema se pueden enviar dos tipos de mensajes:
 * * Mensajes de correo electrónico, el cual contiene un emisor , un receptor (ambas direcciones de email),
 * cuya longitud máxima del mensaje es de 1500 caracteres.
 *
 * También se pueden enviar mensajes de Whatsapp, en el que se necesita el número del teléfono del destinatario
 * y la cantidad máxima de caracteres a enviar es de 600.
 *
 * El sistema de notificaciones se implementará en la función principal (main) y en el se podrán:
 * * Agregar las notificaciones a una cola de notificaciones.
 * * Enviar todas las notificaciones (sean del tipo que sean)
 * * Contar (y mostrar) el tipo de notificaciones existentes:
 * * * Ejemplo 4 notificaciones de correo electronico , 5 notificaciones de Whatsapp
 *
 */
abstract class Notificacion{
    abstract fun enviarMensaje(mensaje: String)
    fun obtenerInformacionMensaje(mensaje: String): String {
        return "Mensaje_ $mensaje \nLongitud: ${mensaje.length}"
    }
}

enum class TipoNotifiacion{
    CORREO, WHATSAPP
}

data class Correo(val emisor : String, val receptor : String) : Notificacion(){

    companion object{
        val MAX_LONGITUD = 1500
    }

    override fun enviarMensaje(mensaje: String) {
        if(mensaje.length > MAX_LONGITUD){
            println("Longitud: $MAX_LONGITUD, excedida")
        }else{
            println(obtenerInformacionMensaje(mensaje))
        }
    }
}

data class Whatsapp(val numeroDestinatario : String) : Notificacion(){

    companion object{
        const val MAX_LONGITUD = 600
    }

    override fun enviarMensaje(mensaje: String) {
        if(mensaje.length > MAX_LONGITUD){
            println("Longitud: $MAX_LONGITUD, excedida")
        }else{
            println(obtenerInformacionMensaje(mensaje))
        }
    }
}

object GestorNotificaciones{
    private val listaNotificaiones = mutableListOf<Notificacion>()

    fun agregarNotificacion(notificacion: Notificacion){
        listaNotificaiones.add(notificacion)
    }

    fun enviarTodas(mensaje: String){
        for(notificacion in listaNotificaiones){
            notificacion.enviarMensaje(mensaje)
        }
    }

    fun contarPorTipo(){
        val correoCount = listaNotificaiones.count{ it is Correo }
        val whatsappCount = listaNotificaiones.count { it is Whatsapp }
        println("$correoCount notificaciones de correo electrónico, $whatsappCount notificaciones de Whatsapp")
    }
}

fun main() {
    val correo1 = Correo("emisor@correo.com", "receptor@correo.com")
    val correo2 = Correo("juan@correo.com", "maria@correo.com")
    val whatsapp1 = Whatsapp("123456789")
    val whatsapp2 = Whatsapp("987654321")

    GestorNotificaciones.agregarNotificacion(correo1)
    GestorNotificaciones.agregarNotificacion(correo2)
    GestorNotificaciones.agregarNotificacion(whatsapp1)
    GestorNotificaciones.agregarNotificacion(whatsapp2)

    val mensaje = "Hola, este es un mensaje de prueba."

    GestorNotificaciones.enviarTodas(mensaje)
    GestorNotificaciones.contarPorTipo()
}

