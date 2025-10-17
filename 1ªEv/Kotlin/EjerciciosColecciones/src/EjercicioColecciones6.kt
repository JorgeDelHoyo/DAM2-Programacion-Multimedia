/**
 *  Imagina que quieres asociar cada compañero con su nota en un examen. Crea un MutableMap<String, Int> llamado notas con estos pares iniciales:
 * Zoe → 7
 * Oscar → 9
 * Lucía → 8
 * Tomás → 7
 *
 * Luego:
 * Imprime el tamaño del mapa.
 * Agrega: Blanca → 8, Maribel → 7.
 * Modifica la nota de Oscar a 7.
 * Imprime la nota de Zoe.
 * Intenta obtener la nota de “Tomás”.
 * Remueve la entrada de Maribel.
 */
fun main() {
    var notas : MutableMap<String, Int> = mutableMapOf(
    "Zoe" to 7,
    "Oscar" to 9,
    "Lucia" to 8,
    "Tomas" to 7)

    println("Tamaño: "+notas.size)
    notas["Blanca"] = 8
    notas["Maribel"]  = 7
    notas["Oscar"] = 7
    println("Nota Zoe: "+notas["Zoe"])
    println("Nota Tomas: "+notas["Tomas"])
    notas.remove("Maribel")
    println(notas)
}