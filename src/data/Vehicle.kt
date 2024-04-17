package data

import java.util.*

abstract class Vehicle(
    val idVehicle: UUID = UUID.randomUUID(),
    val brand: Brand,
    val model: VehicleModel,
    val year: Int,
    val color: Color,
    val mileage: Int,
) {
    abstract fun getVehicleInfo()
}

class Auto(
    brand: Brand,
    model: AutoModel,
    year: Int,
    color: Color,
    mileage: Int,
    val typeAuto: TypeAuto,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("Марка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип кузова: $typeAuto")
    }

}

class Moto(
    brand: Brand,
    model: MotoModel,
    year: Int,
    color: Color,
    mileage: Int,
    val typeMoto: TypeMoto,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {

    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nТип мотоцикла: $typeMoto")
    }

}

class Commercial(
    brand: Brand,
    model: CommercialModel,
    year: Int,
    color: Color,
    mileage: Int,
    val loadCapacity: Double,
) : Vehicle(idVehicle = UUID.randomUUID(), brand, model, year, color, mileage) {
    override fun getVehicleInfo() {
        println("ID: $idVehicle\nМарка: $brand\nМодель: $model\nГод выпуска: $year\nЦвет: $color\nПробег: $mileage\nГрузоподъемность: $loadCapacity")
    }

}

sealed class VehicleModel

open class AutoModel() : VehicleModel()
data class AudiAutoModel(val model: AudiAutoModels?) : AutoModel()
data class BmwAutoModel(val model: BmwAutoModels?) : AutoModel()
data class MazdaAutoModel(val model: MazdaAutoModels?) : AutoModel()
data class KiaAutoModel(val model: KiaAutoModels?) : AutoModel()
data class SkodaAutoModel(val model: SkodaAutoModels?) : AutoModel()

open class MotoModel() : VehicleModel()
data class BmwMotoModel(val model: BmwMotoModels?) : MotoModel()
data class YamahaMotoModel(val model: YamahaMotoModels?) : MotoModel()
data class KawasakiMotoModel(val model: KawasakiMotoModels?) : MotoModel()
data class UralMotoModel(val model: UralMotoModels?) : MotoModel()
data class HondaMotoModel(val model: HondaMotoModels?) : MotoModel()

open class CommercialModel() : VehicleModel()
data class CitroenCommercialModel(val model: CitroenCommercialModels?) : CommercialModel()
data class LadaCommercialModel(val model: LadaCommercialModels?) : CommercialModel()
data class PeugeotCommercialModel(val model: PeugeotCommercialModels?) : CommercialModel()
data class RenaultCommercialModel(val model: RenaultCommercialModels?) : CommercialModel()
data class VolksWagenCommercialModel(val model: VolksWagenCommercialModels?) : CommercialModel()

enum class Brand {
    AUDI,
    BMW,
    MAZDA,
    KIA,
    SKODA,
    YAMAHA,
    KAWASAKI,
    URAL,
    HONDA,
    CITROEN,
    LADA,
    PEUGEOT,
    RENAULT,
    VOLKSWAGEN
}

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

enum class TypeAuto {
    SEDAN,
    HATCHBACK,
    UNIVERSAL,
    UNKNOWN
}

enum class TypeMoto {
    CROSS,
    SPORT,
    GRANTURISMO,
    UNKNOWN
}

enum class Color {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE,
    UNKNOWN
}


