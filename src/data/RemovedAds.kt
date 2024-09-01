package data

import kotlinx.serialization.Serializable

@Serializable
class RemovedAds(
    val ad: Ads,
    val reason: String
)