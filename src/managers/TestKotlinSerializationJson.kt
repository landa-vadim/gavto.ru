package managers

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
enum class Brand {
    BMW,
    MERCEDES
}

@Serializable
class Car (
    val brand: Brand,
    val model: String
)


fun main() {
    val car = Car(Brand.BMW, "X1")
    val car2 = Car(Brand.BMW, "X5")
    val car3 = Car(Brand.MERCEDES, "C")
    val car4 = Car(Brand.MERCEDES, "GL")

    val array = arrayOf(car, car2, car3, car4)
    val jsonString = Json.encodeToString(array)
    println(jsonString)
    val arrayRestored = Json.decodeFromString<Array<Car>>(jsonString)
    arrayRestored.forEach {
        println("${it.brand} -> ${it.model}")
    }
}