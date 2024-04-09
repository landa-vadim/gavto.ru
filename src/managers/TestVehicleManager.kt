package managers

import data.Vehicle

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


//        for (i in vehicleList) {

//        }
//        val userRequestResult = vehicleList.contains(userRequest)

//        return listOfSearch
//    }

//}
}