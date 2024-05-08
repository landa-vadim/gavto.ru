package managers

import data.Ads
import data.RemovedAds
import data.vehicle.Vehicle
import validators.InputValidator
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

    override fun printAllAds() {
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
        saveActiveAds(activeAdsList)
        inActiveAdsList.add(removedAd)
        saveInActiveAds(inActiveAdsList)
        println("Объявление снято с публикации!")
    }

    override fun recoverAd(removedAd: RemovedAds) {
        inActiveAdsList.remove(removedAd)
        saveInActiveAds(inActiveAdsList)
        activeAdsList.add(removedAd.ad)
        saveActiveAds(activeAdsList)
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

    override fun getAllRemovedAds(): List<RemovedAds> {
        inActiveAdsList.forEachIndexed { index, removedAd ->
            println("${index + 1}.")
            removedAd.getReasonToRemoveAd()
        }
        return inActiveAdsList
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