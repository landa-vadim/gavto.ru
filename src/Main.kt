import java.util.Date

fun main() {



val auto1 = Auto(
    idVehicle = 1,
    brand = "BMW",
    model = "3",
    year = 2019,
    color = Color.BLUE,
    mileage = 40000,
    vehicleType = VehicleType.AUTO,
    typeAuto = TypeAuto.SEDAN
    )
    auto1.getVehicleInfo()

    println()

    val owner1 = Owner(
        idOwner = 1,
        name = "Иван",
        telephoneNumber = 89905578121,
        email = "google.ivan@gmail.com"
        )
owner1.getOwnerInfo()

println()

    val ad1 = Ads(
        idAd = 1,
        price = 3000000,
        publicationDate = Date(),
        idOwner = owner1.id,
        idVehicle = auto1.id
    )
    ad1.getAdInfo()




}