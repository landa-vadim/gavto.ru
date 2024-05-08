package data.vehicle

import kotlinx.serialization.Serializable

@Serializable
sealed class AutoModel() : VehicleModel()

@Serializable
data class AudiAutoModel(val model: AudiAutoModels?) : AutoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class BmwAutoModel(val model: BmwAutoModels?) : AutoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class MazdaAutoModel(val model: MazdaAutoModels?) : AutoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class KiaAutoModel(val model: KiaAutoModels?) : AutoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class SkodaAutoModel(val model: SkodaAutoModels?) : AutoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
enum class AudiAutoModels {
    A3,
    A4,
    A6,
    Q3,
    Q5;

    companion object {
        fun getById(ordinal: Int): AudiAutoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class BmwAutoModels {
    M3,
    M5,
    M7,
    X5,
    X6;

    companion object {
        fun getById(ordinal: Int): BmwAutoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class MazdaAutoModels {
    M3,
    M6,
    CX30,
    CX5,
    CX9;

    companion object {
        fun getById(ordinal: Int): MazdaAutoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class KiaAutoModels {
    RIO,
    CERATO,
    OPTIMA,
    SPORTAGE,
    SORENTO;

    companion object {
        fun getById(ordinal: Int): KiaAutoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class SkodaAutoModels {
    RAPID,
    OCTAVIA,
    SUPERB,
    KAROQ,
    KODIAQ;

    companion object {
        fun getById(ordinal: Int): SkodaAutoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
