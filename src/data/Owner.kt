package data

import data.vehicle.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class Owner (
    @Serializable(with = UUIDSerializer::class)
    val idOwner: UUID = UUID.randomUUID(),
    val name: String,
    val telephoneNumber: Long,
    val email: String,
)