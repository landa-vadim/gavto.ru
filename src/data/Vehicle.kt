package data

import java.util.*

abstract class Vehicle(
    val idVehicle: UUID = UUID.randomUUID(),
    val brand: String,
    val model: String,
    val year: Int,
    val color: Color,
    val mileage: Int,
) {
    abstract fun getVehicleInfo()
}
class Auto(
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("Марка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

}

class Moto(
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип мотоцикла: $typeMoto")
    }

}

class Commercial(
    brand: String,
    model: String,
    year: Int,
    color: Color,
    mileage: Int,
    val loadCapacity: Double,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

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

enum class Color() {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE,
    UNKNOWN
}


