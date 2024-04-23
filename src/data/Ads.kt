package data

import managers.AdsManager
import java.util.*

class Ads(
    val idAd: UUID = UUID.randomUUID(),
    val price: Int,
    val publicationDate: Date,
    val idVehicle: UUID, // Vehicle
    val idOwner: UUID,
) {



fun getAdInfo() {
    println("Цена: $price\nДата публикации: $publicationDate")
}

}