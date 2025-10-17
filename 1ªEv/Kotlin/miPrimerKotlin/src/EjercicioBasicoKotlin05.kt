/**
 * Crea una funcion que calcule el valor del parametro perdido correspondiente
 * a la ley de Ohm
 * - Enviaremos a la funcion 2 de los 3 parametros (V,R,I) y retornará el valor del tercero
 * (redondeado a 2 decimales)
 * - Si los parametros son incorrectos o insuficinetes, la funcion devolverá la cadena de texto
 * "valores invalidos"
 */
fun main() {
    println(calcularOhm(v = null, r = 10.0, i = 2.5))
}

fun calcularOhm(v: Double?, r: Double?, i: Double?) : Any{
    return when {
        v == null && r != null && i != null -> String.format("%.2f",r*i).toDouble()
        r == null && v != null && i != null -> if(i != 0.0){
            String.format("%.2f",v/i).toDouble()
        }else{
            println("Valores invalidos")
        }
        i == null && v != null && r != null -> if(r != 0.0){
            String.format("%.2f",v/r).toDouble()
        }else{
            println("Valores invalidos")
        }

        else -> println("Valores invalidos")
    }
}
