/**
 *  Dada una lista de 20  enteros.
 *  Crea una función que devuelva una lista con solo los números mayores que una cantidad que solicites como parámetro por teclado.
 */
fun main() {
    val lista = listOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    print("Ingresa un numeor limite: ")
    val numero = readLine()?.toIntOrNull()

    if(numero != null){
        val resutlado = numerosMayores(lista, numero)
        println("Numeros mayores que $numero : $resutlado")
    }else{
        println("Por favor ingresa un numero valido")
    }
}
fun numerosMayores(lista : List<Int>, numero: Int) : List<Int> {
    val mayores = mutableListOf<Int>()
    for(i in lista){
        if(i > numero){
            mayores.add(i)
        }
    }
    return mayores
}