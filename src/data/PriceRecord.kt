package data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateSerializer : KSerializer<Date> {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    override val descriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder): Date {
        return dateFormat.parse(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(dateFormat.format(value))
    }
}

@Serializable
class PriceRecord(
    @Serializable(with = DateSerializer::class)
    val date: Date,
    val price: Int
) {
    fun getLastPrice() {
        println("Актуальная цена: $price рублей")
    }

    fun getLastPriceForRemovedAd() {
        println("Последняя цена: $price рублей")
    }

    fun getPriceHistory() {
        println("Цена на дату: $date - $price рублей")
    }
}