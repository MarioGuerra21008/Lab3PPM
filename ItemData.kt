// Universidad del Valle de Guatemala
// Programación de Plataformas Móviles - Sección: 20
// Mario Antonio Guerra Morales - Carné: 21008

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any?,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false)) //Lista result para ingresar los datos de la lista.
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? { //Función ProcessList que ejecuta los requerimientos solicitados.
	var lista = ArrayList<ItemData>() //Variable lista para ingresar los datos a mostrar.
    var originalPos: Int = -1; //Contador.
    var originalValue: Any?; //Variable para el nombre del elemento de la lista.
    var type: String? = null; //Tipo de elemento ingresado.
    var info: String? = null //Información de elemento ingresado.
    
    if (inputList != null) { //Si la lista no está vacía ejecuta lo siguiente:
        for (elemento in inputList) { //Ciclo for por cada elemento en la lista.
            originalPos = originalPos + 1 //Suma 1 al contador de posición.
            originalValue = (elemento ?: null) //Agrega al elemento como tal en la variable originalValue.
            when (elemento) { //Si el elemento...
                is Int -> { //Es entero:
                    type = "entero" //Declara que el tipo de variable es entero.
                    var multiplo: Int? = 0 //Variable para declarar múltiplo del entero.
                    if (elemento % 10 == 0) {
                        multiplo = 10 //Es múltiplo de 10.
                        info = "m" + multiplo //Muestra de qué múltiplo es cada número.
                    }
                    else if (elemento % 5 == 0) {
                        multiplo = 5 //Es múltiplo de 5.
                        info = "m" + multiplo //Muestra de qué múltiplo es cada número.
                    }
                    else if (elemento % 2 == 0) {
                        multiplo = 2 //Es múltiplo de 2.
                        info = "m" + multiplo //Muestra de qué múltiplo es cada número.
                    }
                    else {
                        info = null //Es un null.
                    }
                    lista.add(ItemData(originalPos,originalValue,type,info)) //Añade los valores de las variables a la lista.
                }
                is String -> { //Es String:
                    type = "cadena" //Declara que el tipo de variable es una cadena.
                    var largo = elemento.length //Verifica el largo del elemento.
                    info = "l" + largo //Muestra el largo del String.
                    lista.add(ItemData(originalPos,originalValue,type,info)) //Añade los valores de las variables a la lista.
                }
                is Boolean -> { //Es booleano:
                    type = "booleano" //Declara que el tipo de variable es booleano.
                    if (elemento) {
                        info = "verdadero" //Si el elemento es "true", la variable info es verdadero.
                        lista.add(ItemData(originalPos,originalValue,type,info)) //Añade los valores de las variables a la lista.
                    }
                    else {
                        info = "falso" //Si el elemento es "false", la variable info es falso.
                        lista.add(ItemData(originalPos,originalValue,type,info)) //Añade los valores de las variables a la lista.
                    }
                }
                else -> { //Es otro tipo de variable:
                    type = null //Type es igual a null.
                    info = null //Info es igual a null.
                    if (originalValue != null) {
                        lista.add(ItemData(originalPos,originalValue,type,info)) //Añade los valores de las variables a la lista.
                    }
                }
            }
        }
        return lista //Retorna la lista de valores al usuario.
    }
    else {
        return null
    }
}