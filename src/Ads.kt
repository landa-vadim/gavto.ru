import java.util.*

class Ads(
    val idAd: Int,
    val price: Int,
    val publicationDate: Date,
    val idVehicle: Int,
    val idOwner: Int,
): AdsManager {

    val id = idAd

fun getAdInfo() {
    println("ID: $id\nЦена: $price\nДата публикации: $publicationDate")
}

}