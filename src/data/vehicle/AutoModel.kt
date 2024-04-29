package data.vehicle
open class AutoModel() : VehicleModel()
data class AudiAutoModel(val model: AudiAutoModels?) : AutoModel()
data class BmwAutoModel(val model: BmwAutoModels?) : AutoModel()
data class MazdaAutoModel(val model: MazdaAutoModels?) : AutoModel()
data class KiaAutoModel(val model: KiaAutoModels?) : AutoModel()
data class SkodaAutoModel(val model: SkodaAutoModels?) : AutoModel()

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
enum class MazdaAutoModels {
    M3,
    M6,
    CX30,
    CX5,
    CX9;
    companion object {
        fun getById(ordinal: Int): MazdaAutoModels? {
            return  entries.firstOrNull() { it.ordinal == ordinal }
        }
    }
}
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
