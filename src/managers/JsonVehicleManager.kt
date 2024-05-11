package managers

import data.vehicle.Brand
import data.vehicle.Color
import data.vehicle.Vehicle
import data.vehicle.VehicleModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import validators.InputValidator
import java.io.File
import java.util.*

class JsonVehicleManager : VehicleManager {
    private val file = File("vehicles.json")
    val validator = InputValidator()
    private val vehicleList = loadVehicle()

    private fun saveOwner(list: MutableList<Vehicle>) {
        val data = Json.encodeToString(list)
        file.writeText(data)
    }

    private fun loadVehicle(): MutableList<Vehicle> {
        val json = file.readText()
        val data = Json.decodeFromString<MutableList<Vehicle>>(json)
        return data
    }

    override fun addVehicle(vehicle: Vehicle) {
        vehicleList.add(vehicle)
        saveOwner(vehicleList)
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
        userRequestMileage: IntRange,
        userRequestVehicleSpecificInfo: String?
    ): List<Vehicle> {
        val userRequestLoadCapacity = userRequestVehicleSpecificInfo?.toDoubleOrNull()
        val listVehicleOutput = vehicleList.filter { vehicle ->
            val brand = (userRequestBrand == null || vehicle.brand == userRequestBrand)
            val model = (userRequestModel == null || vehicle.model == userRequestModel)
            val year = (userRequestYear == null || vehicle.year >= userRequestYear)
            val color = (userRequestColor == null || vehicle.color == userRequestColor)
            val mileage = (vehicle.mileage in userRequestMileage)
            val isItLoadCapacity =
                if (vehicle.getVehicleSpecificInfo().toDoubleOrNull() != null) vehicle.getVehicleSpecificInfo()
                    .toDoubleOrNull() else 0.0
            val vehicleSpecificInfo =
                if (userRequestLoadCapacity != null) (isItLoadCapacity!! >= userRequestLoadCapacity) else (vehicle.getVehicleSpecificInfo() == userRequestVehicleSpecificInfo)
            brand && model && year && color && mileage && vehicleSpecificInfo
        }
        return listVehicleOutput
    }

}