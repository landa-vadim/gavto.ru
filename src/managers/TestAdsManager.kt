package managers

import data.Ads
import utils.validator
import data.vehicle.Vehicle
import researchVehicle

class TestAdsManager : AdsManager {

    val vehicleManager: TestVehicleManager = TestVehicleManager()
    val activeAdsList = mutableListOf<Ads>()
    val inActiveAdsList = mutableListOf<Ads>()

    override fun addAd(ad: Ads) {
        activeAdsList.add(ad)
    }

    override fun getAllAds() {
        activeAdsList.forEach { ad ->
            println("${activeAdsList.indexOf(ad) + 1}.")
            ad.getAdInfo()
        }
    }

    override fun removeAd(ad: Ads) {
        activeAdsList.remove(ad)
        inActiveAdsList.add(ad)
        println("Объявление снято с публикации!")
    }

    override fun chooseAds(): Ads {

        println("Список всех объявлений:")
        getAllAds()
        val count = activeAdsList.count()
        println("Выберете номер объявления:")
        val adNumber = validator.isStringValidInRange(readln(), 1..count) - 1
        val ad = activeAdsList[adNumber]
        return ad
    }

    override fun searchAds(): List<Ads>? {

        val foundVehicleList = researchVehicle(validator, vehicleManager) ?: return null
        val foundAds = mutableListOf<Ads>()

        for (vehicle in foundVehicleList) {
            for (ad in activeAdsList) {
                if (vehicle == ad.vehicle) foundAds.add(ad)
            }
        }
        return foundAds
    }

}