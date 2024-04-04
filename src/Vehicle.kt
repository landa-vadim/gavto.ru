abstract class Vehicle(
    open val idVehicle: Int,
    open val brand: String,
    open val model: String,
    open val year: Int,
    open val color: Color,
    open val mileage: Int,
) {

}

class Auto(
    override val idVehicle: Int,
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: Color,
    override val mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

}

class Moto(
    override val idVehicle: Int,
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: Color,
    override val mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

}

class Commercial(
    override val idVehicle: Int,
    override val brand: String,
    override val model: String,
    override val year: Int,
    override val color: Color,
    override val mileage: Int,
    val loadCapacity: Double,
) : Vehicle(idVehicle, brand, model, year, color, mileage) {

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
    PINK
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