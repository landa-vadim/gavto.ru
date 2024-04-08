abstract class Vehicle(
    private val idVehicle: Int,
    val brand: String,
    val model: String,
    val year: Int,
    val color: Color,
    val mileage: Int,
    val vehicleType: VehicleType
): VehicleManager {

    val id = idVehicle

}

class Auto(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    vehicleType: VehicleType,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle, brand, model, year, color, mileage, vehicleType = VehicleType.AUTO) {

    fun getVehicleInfo() {
        println("ID: $id\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

    fun addVehicle (auto: Auto) {

    }

}

class Moto(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    vehicleType: VehicleType,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle, brand, model, year, color, mileage, vehicleType = VehicleType.MOTO) {

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
    vehicleType: VehicleType,
    val loadCapacity: Double,
) : Vehicle(idVehicle, brand, model, year, color, mileage, vehicleType = VehicleType.COMMERCIAL) {

    fun getVehicleInfo() {
        println("ID: $id\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nГрузоподъемность: $loadCapacity")
    }

}
enum class VehicleType () {
    AUTO,
    MOTO,
    COMMERCIAL
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

