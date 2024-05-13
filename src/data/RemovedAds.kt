package data

import kotlinx.serialization.Serializable

@Serializable
class RemovedAds(
    val ad: Ads,
    val reason: String
) {
//    fun printReasonToRemoveAd() {
//        println("Объявление")
//        ad.printRemovedAdInfo()
//        println("Снято по причине:\n$reason")
//    }
}