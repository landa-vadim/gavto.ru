package data.vehicle

import java.util.*

abstract class Vehicle(
    val idVehicle: UUID = UUID.randomUUID(),
    val brand: Brand,
    val model: VehicleModel,
    val year: Int,
    val color: Color,
    val mileage: Int,
) {
    abstract fun getVehicleInfo()
    abstract fun getVehicleSpecificInfo(): String
}

class Auto(
    brand: Brand,
    model: AutoModel,
    year: Int,
    color: Color,
    mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("Марка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

    override fun getVehicleSpecificInfo(): String {
        return "$typeAuto"
    }

}

class Moto(
    brand: Brand,
    model: MotoModel,
    year: Int,
    color: Color,
    mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип мотоцикла: $typeMoto")
    }

    override fun getVehicleSpecificInfo(): String {
        return "$typeMoto"
    }

}

class Commercial(
    brand: Brand,
    model: CommercialModel,
    year: Int,
    color: Color,
    mileage: Int,
    val loadCapacity: Double,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {
    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nГрузоподъемность: $loadCapacity")
    }

    override fun getVehicleSpecificInfo(): String {
        return "$loadCapacity"
    }

}
enum class TypeAuto {
    SEDAN,
    HATCHBACK,
    UNIVERSAL,
    UNKNOWN
}

enum class TypeMoto {
    CROSS,
    SPORT,
    GRANTURISMO,
    UNKNOWN
}

enum class Color {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE,
    UNKNOWN
}


