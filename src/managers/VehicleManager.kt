package managers

import data.vehicle.Brand
import data.vehicle.Color
import data.vehicle.Vehicle
import data.vehicle.VehicleModel
import java.util.UUID

interface VehicleManager {
    fun addVehicle(vehicle: Vehicle)
    fun getAllVehicle(): List<Vehicle>
    fun getVehicleByID(idVehicle: UUID): Vehicle?
    fun searchVehicle(
        userRequestBrand: Brand?,
        userRequestModel: VehicleModel?,
        userRequestYear: Int?,
        userRequestColor: Color?,
        userRequestMileage: IntRange,
        userRequestVehicleSpecificInfo: String?,
    ): List<Vehicle>
    fun getVehicleFromList(vehicleWithoutAdsList: List<Vehicle>): Vehicle?
}