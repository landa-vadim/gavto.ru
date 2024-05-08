package data.vehicle

import kotlinx.serialization.Serializable

@Serializable
sealed class CommercialModel() : VehicleModel()

@Serializable
data class CitroenCommercialModel(val model: CitroenCommercialModels?) : CommercialModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class LadaCommercialModel(val model: LadaCommercialModels?) : CommercialModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class PeugeotCommercialModel(val model: PeugeotCommercialModels?) : CommercialModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class RenaultCommercialModel(val model: RenaultCommercialModels?) : CommercialModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class VolksWagenCommercialModel(val model: VolksWagenCommercialModels?) : CommercialModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
enum class CitroenCommercialModels {
    BERLINGO;

    companion object {
        fun getById(ordinal: Int): CitroenCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class LadaCommercialModels {
    LARGUS;

    companion object {
        fun getById(ordinal: Int): LadaCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class PeugeotCommercialModels {
    PARTNER;

    companion object {
        fun getById(ordinal: Int): PeugeotCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class RenaultCommercialModels {
    DOKKER;

    companion object {
        fun getById(ordinal: Int): RenaultCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class VolksWagenCommercialModels {
    CADDY;

    companion object {
        fun getById(ordinal: Int): VolksWagenCommercialModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
