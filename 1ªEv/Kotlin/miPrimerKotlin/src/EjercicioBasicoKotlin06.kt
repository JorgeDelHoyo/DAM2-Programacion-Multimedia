/**
 * Escribe un programa, que pasando como parámetro una frase, encuentre:
 * - La primera posición de una letra dada
 * - La primera posición de una palabra dada
 * - Busque si una palabra se encuentra o no en la frase
 */
fun main() {

}

fun buscarPalabra(palabra : String, texto : String) {
    val t = texto.length
    val p = palabra.length

    for(i in 0..t - p) {
        var encontrada = true
        for(j in 0 until p){
            if(texto[i+j] != palabra[j]){

            }
        }
    }
}