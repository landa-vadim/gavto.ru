package managers

import data.Ads
import java.util.*

interface AdsManager {

    fun addAd(ad: Ads)

    fun getAllAds()

    fun removeAd(ad: Ads)

    fun searchAds()

    fun priceData(ad: Ads)

    fun changeAdPrice(ad: Ads)


}