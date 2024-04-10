package managers

import data.Ads

interface AdsManager {

    fun addAd(ad: Ads)

    fun getAllAds()

    fun removeAd(ad: Ads)

    fun searchAds()


}