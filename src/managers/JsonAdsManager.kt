package managers

import data.Ads
import data.RemovedAds
import data.vehicle.Vehicle
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class JsonAdsManager : AdsManager {
    private val fileActive = File("activeAds.json")
    private val fileInActive = File("inActiveAds.json")
    private val activeAdsList = loadActiveAds()
    private val inActiveAdsList = loadInActiveAds()

    private fun saveActiveAds(list: MutableList<Ads>) {
        val data = Json.encodeToString(list)
        fileActive.writeText(data)
    }

    private fun loadActiveAds(): MutableList<Ads> {
        val json = fileActive.readText()
        val data = Json.decodeFromString<MutableList<Ads>>(json)
        return data
    }

    private fun saveInActiveAds(list: MutableList<RemovedAds>) {
        val data = Json.encodeToString(list)
        fileInActive.writeText(data)
    }

    private fun loadInActiveAds(): MutableList<RemovedAds> {
        val json = fileInActive.readText()
        val data = Json.decodeFromString<MutableList<RemovedAds>>(json)
        return data
    }

    override fun addAd(ad: Ads) {
        activeAdsList.add(ad)
        saveActiveAds(activeAdsList)
    }

    override fun getAllAds(): List<Ads> {
        return activeAdsList
    }

    override fun removeAd(ad: Ads, reason: String) {
        val removedAd = RemovedAds(ad, reason)
        activeAdsList.remove(ad)
        saveActiveAds(activeAdsList)
        inActiveAdsList.add(removedAd)
        saveInActiveAds(inActiveAdsList)

    }

    override fun recoverAd(removedAd: RemovedAds) {
        inActiveAdsList.remove(removedAd)
        saveInActiveAds(inActiveAdsList)
        activeAdsList.add(removedAd.ad)
        saveActiveAds(activeAdsList)
    }

    override fun getAllRemovedAds(): List<RemovedAds> {
        return inActiveAdsList
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