package managers

import data.Ads
import java.util.*

interface AdsManager {

    fun addAd(ad: Ads)

    fun getAllAds()

    fun removeAd(ad: Ads)

    fun chooseAds(): Ads

    fun searchAds(): List<Ads>?


}