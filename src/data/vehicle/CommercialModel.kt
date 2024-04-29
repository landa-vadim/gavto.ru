package data.vehicle
open class CommercialModel() : VehicleModel()
data class CitroenCommercialModel(val model: CitroenCommercialModels?) : CommercialModel()
data class LadaCommercialModel(val model: LadaCommercialModels?) : CommercialModel()
data class PeugeotCommercialModel(val model: PeugeotCommercialModels?) : CommercialModel()
data class RenaultCommercialModel(val model: RenaultCommercialModels?) : CommercialModel()
data class VolksWagenCommercialModel(val model: VolksWagenCommercialModels?) : CommercialModel()

enum class CitroenCommercialModels {
    BERLINGO;
    companion object {
        fun getById(ordinal: Int): CitroenCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
enum class LadaCommercialModels {
    LARGUS;
    companion object {
        fun getById(ordinal: Int): LadaCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
enum class PeugeotCommercialModels {
    PARTNER;
    companion object {
        fun getById(ordinal: Int): PeugeotCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
enum class RenaultCommercialModels {
    DOKKER;
    companion object {
        fun getById(ordinal: Int): RenaultCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
enum class VolksWagenCommercialModels {
    CADDY;
    companion object {
        fun getById(ordinal: Int): VolksWagenCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
