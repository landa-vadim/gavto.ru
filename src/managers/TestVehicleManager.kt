package managers

import data.*
import validators.InputValidator
import java.util.*

class TestVehicleManager : VehicleManager {

    val vehicleList = mutableListOf<Vehicle>()

    override fun addVehicle(vehicle: Vehicle) {
        vehicleList.add(vehicle)
    }

    override fun getAllVehicle(): List<Vehicle> {
        return vehicleList
    }

    override fun getVehicleByID(idVehicle: UUID): Vehicle? {

        for (vehicle in vehicleList) {
            if (vehicle.idVehicle == idVehicle) {
                return vehicle
            }
        }
        return null
    }

    override fun searchVehicle(
        userRequestBrand: Brand?,
        userRequestModel: VehicleModel?,
        userRequestYear: Int,
        userRequestColor: Color?,
        userRequestMileage: Int,
        userRequestVehicleSpecificInfo: String?,
        vehicleList: List<Vehicle>
    ): List<Vehicle> {

        val listVehicleOut = mutableListOf<Vehicle>()

        for (vehicle in vehicleList) {
            if (userRequestBrand == null || vehicle.brand == userRequestBrand) {
                if (userRequestModel == null || vehicle.model == userRequestModel) {
                    if (userRequestYear == 0 || vehicle.year >= userRequestYear) {
                        if (userRequestColor == null || vehicle.color == userRequestColor) {
                            if (userRequestMileage == 0 || vehicle.mileage <= userRequestMileage) {
                                if (userRequestVehicleSpecificInfo == null || vehicle.getVehicleSpecificInfo() == userRequestVehicleSpecificInfo) {
                                    listVehicleOut.add(vehicle)
                                }
                            }
                        }
                    }
                }
            }
        }
        return listVehicleOut
    }

}