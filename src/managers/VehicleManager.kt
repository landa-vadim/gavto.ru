package managers

import data.Vehicle

interface VehicleManager {

    fun addVehicle(vehicle: Vehicle)

    fun getAllVehicle(): List<Vehicle>

    fun searchVehicle(userRequest: Vehicle, vehicleList: List<Vehicle>): List<Vehicle>      //searchCriteria: VehicleSearchCriteria



}