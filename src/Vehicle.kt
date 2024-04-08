abstract class Vehicle(
    private val idVehicle: Int,
    val brand: String,
    val model: String,
    val year: Int,
    val color: Color,
    val mileage: Int,
) {

}

class Auto(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

    private val id = idVehicle

    fun getVehicleInfo() {
        println("ID: $id\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

}

class Moto(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {
    private val id = idVehicle
    fun getVehicleInfo() {
        println("ID: $id\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип мотоцикла: $typeMoto")
    }

}

class Commercial(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    val loadCapacity: Double,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {
    private val id = idVehicle
    fun getVehicleInfo() {
        println("ID: $id\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nГрузоподъемность: $loadCapacity")
    }

}

enum class Color() {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE,
    YELLOW,
    SILVER,
    BROWN,
    GOLD,
    PINK,
    ORANGE,
    PURPLE
}

enum class TypeAuto() {
    SEDAN,
    HATCHBACK,
    UNIVERSAL
}

enum class TypeMoto() {
    CROSS,
    SPORT,
    GRANTURISMO
}

