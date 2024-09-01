package data.vehicle

import kotlinx.serialization.Serializable

@Serializable
sealed class MotoModel : VehicleModel()

@Serializable
data class BmwMotoModel(val model: BmwMotoModels?) : MotoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class YamahaMotoModel(val model: YamahaMotoModels?) : MotoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class KawasakiMotoModel(val model: KawasakiMotoModels?) : MotoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class UralMotoModel(val model: UralMotoModels?) : MotoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
data class HondaMotoModel(val model: HondaMotoModels?) : MotoModel() {
    override fun toString(): String {
        return model.toString()
    }
}

@Serializable
enum class BmwMotoModels {
    M,
    K,
    G,
    R,
    C;

    companion object {
        fun getById(ordinal: Int): BmwMotoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class YamahaMotoModels {
    MT,
    XSR,
    XT,
    XV,
    YZF;

    companion object {
        fun getById(ordinal: Int): YamahaMotoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class KawasakiMotoModels {
    EN,
    ER,
    KX,
    NINJA,
    Z;

    companion object {
        fun getById(ordinal: Int): KawasakiMotoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class UralMotoModels {
    M,
    SOLO,
    TOURIST,
    VOYAZH,
    WOLF;

    companion object {
        fun getById(ordinal: Int): UralMotoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}

@Serializable
enum class HondaMotoModels {
    CB,
    CBF,
    CBR,
    CRF,
    GL;

    companion object {
        fun getById(ordinal: Int): HondaMotoModels? {
            return entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}