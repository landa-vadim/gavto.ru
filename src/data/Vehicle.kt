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

enum class BrandAuto() {
    AUDI,
    BMW,
    MAZDA,
    KIA,
    SKODA
}

enum class AudiAutoModels() {
    A3,
    A4,
    A6,
    Q3,
    Q5
}

enum class BMWAutoModels() {
    M3,
    M5,
    M7,
    X5,
    X6
}

enum class MazdaAutoModels() {
    M3,
    M6,
    CX30,
    CX5,
    CX9
}

enum class KIAAutoModels() {
    RIO,
    CERATO,
    OPTIMA,
    SPORTAGE,
    SORENTO
}

enum class SkodaAutoModels() {
    RAPID,
    OCTAVIA,
    SUPERB,
    KAROQ,
    KODIAQ
}

enum class BrandMoto() {
    BMW,
    YAMAHA,
    KAWASAKI,
    URAL,
    HONDA
}

enum class BMWMotoModels() {
    M,
    K,
    G,
    R,
    C
}

enum class YamahaMotoModels() {
    MT,
    XSR,
    XT,
    XV,
    YZF
}

enum class KawasakiMotoModels() {
    EN,
    ER,
    KX,
    Ninja,
    Z
}

enum class UralMotoModels() {
    M,
    SOLO,
    TOURIST,
    VOYAZH,
    WOLF
}

enum class HondaMotoModels() {
    CB,
    CBF,
    CBR,
    CRF,
    GL
}

enum class BrandCommercial() {
    CITROEN,
    LADA,
    PEUGEOT,
    RENAULT,
    VOLKSWAGEN
}

enum class CitroenCommercialModels() {
    BERLINGO
}

enum class LadaCommercialModels() {
    LARGUS
}

enum class PeugeotCommercialModels() {
    PARTNER
}

enum class RenaultCommercialModels() {
    DOKKER
}

enum class VolksWagenCommercialModels() {
    CADDY
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


