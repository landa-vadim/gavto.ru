package managers

import data.Ads
import utils.validator
import java.util.*

class TestAdsManager : AdsManager {

    val vehicleManager: TestVehicleManager = TestVehicleManager()

    val activeAdsList = mutableListOf<Ads>()
    val inActiveAdsList = mutableListOf<Ads>()

    override fun addAd(ad: Ads) {
        activeAdsList.add(ad)
        priceData(ad)
    }

    override fun getAllAds() {
        for (i in activeAdsList) {
            i.getAdInfo()
            i.vehicle.getVehicleInfo()
        }
    }

    override fun removeAd(ad: Ads) {
        activeAdsList.remove(ad)
        inActiveAdsList.add(ad)
    }

    override fun searchAds() {

    }

    override fun priceData(ad: Ads) {


    }

    override fun changeAdPrice(ad: Ads) {

        do {
            println("Введите новую цену:")
            ad.price = validator.isStringValidInRange(readln(), 1..99999999)
        } while (ad.price == 0)

    }



}