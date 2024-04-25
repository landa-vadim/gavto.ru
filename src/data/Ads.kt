package data

import data.vehicle.Vehicle
import managers.AdsManager
import java.util.*

class Ads(
    val idAd: UUID = UUID.randomUUID(),
    val vehicle: Vehicle,
    val owner: Owner,
    val priceHistory: MutableList<PriceRecord>
) {

    fun getAdInfo() {

        owner.getOwnerInfo()
        vehicle.getVehicleInfo()
        val count = priceHistory.count()
        val lastIndex = count - 1
        if (count > 1) {
            println("История изменение цены:")
            priceHistory.forEach { price ->
                price.getPriceHistory()
            }
            priceHistory[lastIndex].getLastPrice()
        } else priceHistory[0].getLastPrice()
        println("----------------------------------------------------------------")
    }


}