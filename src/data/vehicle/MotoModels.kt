package data.vehicle

open class MotoModel() : VehicleModel()
data class BmwMotoModel(val model: BmwMotoModels?) : MotoModel()
data class YamahaMotoModel(val model: YamahaMotoModels?) : MotoModel()
data class KawasakiMotoModel(val model: KawasakiMotoModels?) : MotoModel()
data class UralMotoModel(val model: UralMotoModels?) : MotoModel()
data class HondaMotoModel(val model: HondaMotoModels?) : MotoModel()
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