package managers

import data.Ads
import data.RemovedAds
import data.vehicle.Vehicle
import validators.InputValidator

interface AdsManager {
    fun addAd(ad: Ads)
    fun getAllAds(): List<Ads>
    fun removeAd(ad: Ads, reason: String)
    fun recoverAd(removedAd: RemovedAds)
    fun getAllRemovedAds(): List<RemovedAds>
    fun searchAds(foundVehicleList: List<Vehicle>?): List<Ads>?
}