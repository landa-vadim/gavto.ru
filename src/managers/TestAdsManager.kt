package managers

import data.Ads
import data.RemovedAds
import data.vehicle.Vehicle
import utils.validator
import researchVehicle
import validators.InputValidator

class TestAdsManager : AdsManager {
    private val vehicleManager: TestVehicleManager = TestVehicleManager()
    private val activeAdsList = mutableListOf<Ads>()
    private val inActiveAdsList = mutableListOf<RemovedAds>()

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
        println("Введите причину снятия объявления:")
        val reason = readln()
        val removedAd = RemovedAds(ad, reason)
        activeAdsList.remove(ad)
        inActiveAdsList.add(removedAd)
        println("Объявление снято с публикации!")
    }

    override fun recoverAd(removedAd: RemovedAds) {
        inActiveAdsList.remove(removedAd)
        activeAdsList.add(removedAd.ad)
        println("Объявление опубликовано вновь!")
    }

    override fun chooseAds(validator: InputValidator): Ads {
        println("Список всех объявлений:")
        getAllAds()
        val count = activeAdsList.count()
        println("Выберете номер объявления:")
        val adNumber = validator.isStringValidInRange(readln(), 1..count) - 1
        val ad = activeAdsList[adNumber]
        return ad
    }

    override fun getAllRemovedAds() {
        var count = 1
        println("$count++.")
        inActiveAdsList.forEach { removedAd ->
            removedAd.getReasonToRemoveAd()
        }
    }

    override fun chooseRemovedAds(validator: InputValidator): RemovedAds {
        println("Список всех снятых объявлений:")
        getAllRemovedAds()
        val count = inActiveAdsList.count()
        println("Выберете номер объявления:")
        val adNumber = validator.isStringValidInRange(readln(), 1..count) - 1
        val removedAd = inActiveAdsList[adNumber]
        return removedAd
    }

    override fun searchAds(foundVehicleList: List<Vehicle>?): List<Ads>? {
        if (foundVehicleList == null) return null
        val foundAds = mutableListOf<Ads>()
        for (vehicle in foundVehicleList) {
            for (ad in activeAdsList) {
                if (vehicle == ad.vehicle) foundAds.add(ad)
            }
        }
        return foundAds
    }
}