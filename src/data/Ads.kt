package data

import data.vehicle.UUIDSerializer
import data.vehicle.Vehicle
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class Ads(
    @Serializable(with = UUIDSerializer::class)
    val idAd: UUID = UUID.randomUUID(),
    val vehicle: Vehicle,
    val owner: Owner,
    val priceHistory: MutableList<PriceRecord>
)