package managers

import data.Vehicle
import java.util.*

class TestVehicleManager : VehicleManager {

    val vehicleList = mutableListOf<Vehicle>()

    override fun addVehicle(vehicle: Vehicle) {
        vehicleList.add(vehicle)
    }

    override fun getAllVehicle(): List<Vehicle> {
        return vehicleList
    }


    override fun searchVehicle(userRequest: Vehicle, vehicleList: List<Vehicle>): List<Vehicle> {

        val listVehicleOut = mutableListOf<Vehicle>()

        for (vehicle in vehicleList) {
            if (vehicle == userRequest) {
                listVehicleOut.add(vehicle)
            }
        }
        return listVehicleOut
    }

    override fun getVehicleByID(idVehicle: UUID): Vehicle {

        for (vehicle in vehicleList) {
            if (vehicle.idVehicle == idVehicle) {
                return vehicle
            } else return vehicleList[0]
        }
        return vehicleList[0]
    }

}