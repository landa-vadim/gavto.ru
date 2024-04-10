package managers

import data.Vehicle
import java.util.UUID

interface VehicleManager {

    fun addVehicle(vehicle: Vehicle)

    fun getAllVehicle(): List<Vehicle>

    fun searchVehicle(userRequest: Vehicle, vehicleList: List<Vehicle>): List<Vehicle>      //searchCriteria: VehicleSearchCriteria

    fun getVehicleByID(idVehicle: UUID): Vehicle

}