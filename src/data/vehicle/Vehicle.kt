package data.vehicle

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

object UUIDSerializer : KSerializer<UUID> {
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}

@Serializable
sealed class Vehicle {

    abstract val idVehicle: UUID
    abstract val brand: Brand
    abstract val model: VehicleModel
    abstract val year: Int
    abstract val color: Color
    abstract val mileage: Int

    abstract fun getVehicleInfo()
    abstract fun getVehicleSpecificInfo(): String
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return idVehicle == other.idVehicle
        }
        return super.equals(other)
    }
}

@Serializable
class Auto(
    @Serializable(with = UUIDSerializer::class)
    override val idVehicle: UUID = UUID.randomUUID(),
    override val brand: Brand,
    override val model: AutoModel,
    override val year: Int,
    override val color: Color,
    override val mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle() {
    override fun getVehicleInfo() {
        println("Марка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

    override fun getVehicleSpecificInfo(): String {
        return "$typeAuto"
    }
}

@Serializable
class Moto(
    @Serializable(with = UUIDSerializer::class)
    override val idVehicle: UUID = UUID.randomUUID(),
    override val brand: Brand,
    override val model: MotoModel,
    override val year: Int,
    override val color: Color,
    override val mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle() {
    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип мотоцикла: $typeMoto")
    }

    override fun getVehicleSpecificInfo(): String {
        return "$typeMoto"
    }
}

@Serializable
class Commercial(
    @Serializable(with = UUIDSerializer::class)
    override val idVehicle: UUID = UUID.randomUUID(),
    override val brand: Brand,
    override val model: CommercialModel,
    override val year: Int,
    override val color: Color,
    override val mileage: Int,
    val loadCapacity: Double,
) : Vehicle() {
    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nГрузоподъемность: $loadCapacity")
    }

    override fun getVehicleSpecificInfo(): String {
        return "$loadCapacity"
    }
}

@Serializable
enum class TypeAuto {
    SEDAN,
    HATCHBACK,
    UNIVERSAL
}

@Serializable
enum class TypeMoto {
    CROSS,
    SPORT,
    GRANTURISMO
}

@Serializable
enum class Color {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE
}