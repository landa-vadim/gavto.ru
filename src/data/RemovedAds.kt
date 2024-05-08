package data

import kotlinx.serialization.Serializable

@Serializable
class RemovedAds(
    val ad: Ads,
    val reason: String
) {
    fun getReasonToRemoveAd() {
        println("Объявление")
        ad.getAdInfoForRemovedAd()
        println("Снято по причине:\n$reason")
    }
}