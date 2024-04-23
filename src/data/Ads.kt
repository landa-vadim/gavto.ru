package data

import data.vehicle.Vehicle
import managers.AdsManager
import java.util.*

class Ads(
    val idAd: UUID = UUID.randomUUID(),
    val price: Int,
    val publicationDate: Date,
    val vehicle: Vehicle,
    val Owner: Owner,
) {



fun getAdInfo() {
    println("Цена: $price\nДата публикации: $publicationDate")
    vehicle.getVehicleInfo()
}

}