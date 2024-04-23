package managers

import data.vehicle.Brand
import data.vehicle.Color
import data.vehicle.Vehicle
import data.vehicle.VehicleModel
import java.util.*

class TestVehicleManager : VehicleManager {

    private val vehicleList = mutableListOf<Vehicle>()

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
        userRequestVehicleSpecificInfo: String?
    ): List<Vehicle> {

        val userRequestLoadCapacity = userRequestVehicleSpecificInfo?.toDoubleOrNull()

        val listVehicleOutput = vehicleList.filter { vehicle ->
            val brand = (userRequestBrand == null || vehicle.brand == userRequestBrand)
            val model = (userRequestModel == null || vehicle.model == userRequestModel)
            val year = (userRequestYear == null || vehicle.year >= userRequestYear)
            val color = (userRequestColor == null || vehicle.color == userRequestColor)
            val mileage = (userRequestMileage == null || vehicle.mileage <= userRequestMileage)
            val isItLoadCapacity =
                if (vehicle.getVehicleSpecificInfo().toDoubleOrNull() != null) vehicle.getVehicleSpecificInfo().toDoubleOrNull() else 0.0
            val vehicleSpecificInfo =
                if (userRequestLoadCapacity != null) (isItLoadCapacity!! >= userRequestLoadCapacity) else (vehicle.getVehicleSpecificInfo() == userRequestVehicleSpecificInfo)
            brand && model && year && color && mileage && vehicleSpecificInfo
        }
        return listVehicleOutput
    }

}