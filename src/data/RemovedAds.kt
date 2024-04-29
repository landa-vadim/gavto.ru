package data

class RemovedAds(
    val ad: Ads,
    val reason: String
) {
    fun getReasonToRemoveAd() {
        println("Объявление ${ad.getAdInfoForRemovedAd()}\nСнято по причине:\n$reason")
    }
}