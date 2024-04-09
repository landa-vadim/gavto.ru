package data

abstract class Vehicle(
    val idVehicle: Int,
    val brand: String,
    val model: String,
    val year: Int,
    val color: String,
    val mileage: Int,
) {
    abstract fun getVehicleInfo()
}
class Auto(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: String,
    mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

}

class Moto(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: String,
    mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип мотоцикла: $typeMoto")
    }

}

class Commercial(
    idVehicle: Int,
    brand: String,
    model: String,
    year: Int,
    color: String,
    mileage: Int,
    val loadCapacity: Double,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nГрузоподъемность: $loadCapacity")
    }

}


enum class TypeAuto() {
    SEDAN,
    HATCHBACK,
    UNIVERSAL,
    UNKNOWN
}

enum class TypeMoto() {
    CROSS,
    SPORT,
    GRANTURISMO,
    UNKNOWN
}

