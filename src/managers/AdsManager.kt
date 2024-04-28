package managers

import data.Ads
import data.RemovedAds
import java.util.*

interface AdsManager {
    fun addAd(ad: Ads)
    fun getAllAds()
    fun removeAd(ad: Ads)
    fun recoverAd(removedAd: RemovedAds)
    fun chooseAds(): Ads
    fun getAllRemovedAds()
    fun chooseRemovedAds(): RemovedAds
    fun searchAds(): List<Ads>?
}