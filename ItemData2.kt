// Universidad del Valle de Guatemala
// Programación de Plataformas Móviles - Sección: 20
// Mario Antonio Guerra Morales - Carné: 21008

// Don't touch this class ---
data class ItemData2(
    var originalPos: Int,
    var originalValue: Any?,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData2>? {
	var lista = ArrayList<ItemData2>() //List that saves the items from the list.
    var originalPos: Int = -1 //Counter.
    var originalValue: Any? //Variable for the name of each element in the list.
    var type: String? //Element's type.
    var info: String? //Element's information.
    
    if (inputList != null) { //If the list isn't empty do the following:
        for (elemento in inputList) { //For loop for every element in the list.
            originalPos = originalPos + 1 //Add 1 to the counter.
            originalValue = elemento //Element is assigned in originalValue.
            info = null
            when (elemento) {
                is Int -> {
                    type = "entero"
                    when { //Shows the multiple of the element.
                        (elemento % 10) == 0 -> info = "m10"
                        (elemento % 5) == 0 -> info = "m5"
                        (elemento % 2) == 0 -> info = "m2"
                    }
                    lista.add(ItemData2(originalPos,originalValue,type,info)) //Adds the information to the list "lista".
                }
                is String -> {
                    type = "cadena"
                    info = "l" + elemento.length //Shows the length of the element.
                    lista.add(ItemData2(originalPos,originalValue,type,info))
                }
                is Boolean -> {
                    type = "booleano"
                    when {
                        elemento == true -> info = "verdadero" //If the element is "true", the variable info is "verdadero".
                        elemento == false -> info = "falso" //If the element is "false", the variable info is "falso".
                    }
                    lista.add(ItemData2(originalPos,originalValue,type,info))
                }
                else -> { //Is other type of variable:
                    type = null
                    if (originalValue != null) {
                        lista.add(ItemData2(originalPos,originalValue,type,info))
                    }
                }
            }
        }
        return lista
    }
    else {
        return null
    }
}