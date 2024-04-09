package data

import managers.AdsManager
import java.util.*

class Ads(
    val idAd: Int,
    val price: Int,
    val publicationDate: Date,
    val idVehicle: Int,
    val idOwner: Int,
) {



fun getAdInfo() {
    println("ID: $idAd\nЦена: $price\nДата публикации: $publicationDate")
}

}