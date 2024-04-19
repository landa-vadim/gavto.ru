package managers

import data.*
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
        userRequestYear: Int?,
        userRequestColor: Color?,
        userRequestMileage: Int?,
        userRequestVehicleSpecificInfo: String?,
        vehicleList: List<Vehicle>
    ): List<Vehicle> {

        val listVehicleOutput = mutableListOf<Vehicle>()

        for (vehicle in vehicleList) {
            if (userRequestBrand == null || vehicle.brand == userRequestBrand) {
                if (userRequestModel == null || vehicle.model == userRequestModel) {
                    if (userRequestYear == null || vehicle.year >= userRequestYear) {
                        if (userRequestColor == null || vehicle.color == userRequestColor) {
                            if (userRequestMileage == null || vehicle.mileage <= userRequestMileage) {
                                if (userRequestVehicleSpecificInfo == null || vehicle.getVehicleSpecificInfo() == userRequestVehicleSpecificInfo) {
                                    listVehicleOutput.add(vehicle)
                                }
                            }
                        }
                    }
                }
            }
        }
        return listVehicleOutput
    }

}