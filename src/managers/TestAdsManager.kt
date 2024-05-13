package managers

import data.Ads
import data.RemovedAds
import data.vehicle.Vehicle

class TestAdsManager : AdsManager {
    private val activeAdsList = mutableListOf<Ads>()
    private val inActiveAdsList = mutableListOf<RemovedAds>()

    override fun addAd(ad: Ads) {
        activeAdsList.add(ad)
    }

    override fun getAllAds(): List<Ads> {
        return activeAdsList
    }

//    override fun printAllAds() {
//        activeAdsList.forEachIndexed { index, ad ->
//            println("${index + 1}.")
//            ad.printAdInfo()
//        }
//    }

    override fun removeAd(ad: Ads, reason: String) {
        val removedAd = RemovedAds(ad, reason)
        activeAdsList.remove(ad)
        inActiveAdsList.add(removedAd)

    }

    override fun recoverAd(removedAd: RemovedAds) {
        inActiveAdsList.remove(removedAd)
        activeAdsList.add(removedAd.ad)
    }

//    override fun chooseAds(adNumber: Int): Ads {
//        val ad = activeAdsList[adNumber]
//        return ad
//    }

    override fun getAllRemovedAds(): List<RemovedAds> {
        return inActiveAdsList
    }

//    override fun printAllRemovedAds() {
//        inActiveAdsList.forEachIndexed { index, removedAd ->
//            println("${index + 1}.")
//            removedAd.printReasonToRemoveAd()
//        }
//    }

//    override fun chooseRemovedAds(adNumber: Int): RemovedAds {
//        val removedAd = inActiveAdsList[adNumber]
//        return removedAd
//    }

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