package data

import data.vehicle.UUIDSerializer
import data.vehicle.Vehicle
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class Ads(
    @Serializable(with = UUIDSerializer::class)
    val idAd: UUID = UUID.randomUUID(),
    val vehicle: Vehicle,
    val owner: Owner,
    val priceHistory: MutableList<PriceRecord>
) {
//    fun printAdInfo() {
//        owner.printOwnerInfo()
//        vehicle.getVehicleInfo()
//        val count = priceHistory.count()
//        val lastIndex = count - 1
//        if (count > 1) {
//            println("История изменение цены:")
//            priceHistory.forEach { price ->
//                price.printPriceHistory()
//            }
//            priceHistory[lastIndex].printLastPrice()
//        } else priceHistory[0].printLastPrice()
//        println("----------------------------------------------------------------")
//    }
//    fun printRemovedAdInfo() {
//        owner.printOwnerInfo()
//        vehicle.getVehicleInfo()
//        val count = priceHistory.count()
//        val lastIndex = count - 1
//        if (count > 1) {
//            println("История изменение цены:")
//            priceHistory.forEach { price ->
//                price.printPriceHistory()
//            }
//            priceHistory[lastIndex].printLastPriceForRemovedAd()
//        } else priceHistory[0].printLastPriceForRemovedAd()
//        println("----------------------------------------------------------------")
//    }
}