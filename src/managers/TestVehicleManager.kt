package managers

import data.Vehicle

class TestVehicleManager : VehicleManager {

    val vehicleList = mutableListOf<Vehicle>()

    override fun addVehicle(vehicle: Vehicle) {
        vehicleList.add(vehicle)
    }

    override fun getAllVehicle():List<Vehicle> {
        return vehicleList
    }

    override fun searchVehicle() {
        TODO("Not yet implemented")
    }

}