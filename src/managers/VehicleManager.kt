package managers

import data.Brand
import data.Color
import data.Vehicle
import data.VehicleModel
import java.util.UUID

interface VehicleManager {

    fun addVehicle(vehicle: Vehicle)

    fun getAllVehicle(): List<Vehicle>

    fun getVehicleByID(idVehicle: UUID): Vehicle?

    fun searchVehicle(
        userRequestBrand: Brand?,
        userRequestModel: VehicleModel?,
        userRequestYear: Int,
        userRequestColor: Color?,
        userRequestMileage: Int,
        userRequestVehicleSpecificInfo: String?,
        vehicleList: List<Vehicle>
    ): List<Vehicle>      //searchCriteria: VehicleSearchCriteria


}