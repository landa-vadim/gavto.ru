package managers

import data.Ads
import data.RemovedAds
import data.vehicle.Vehicle
import validators.InputValidator

interface AdsManager {
    fun addAd(ad: Ads)
    fun getAllAds()
    fun removeAd(ad: Ads)
    fun recoverAd(removedAd: RemovedAds)
    fun chooseAds(validator: InputValidator): Ads
    fun getAllRemovedAds()
    fun chooseRemovedAds(validator: InputValidator): RemovedAds
    fun searchAds(foundVehicleList: List<Vehicle>?): List<Ads>?
}