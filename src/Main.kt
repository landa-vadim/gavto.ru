import data.*
import jdk.incubator.vector.VectorOperators.Test
import managers.TestVehicleManager
import managers.VehicleManager
import java.util.Date

fun main() {

    val vehicleManager: VehicleManager = TestVehicleManager()


    val auto1 = Auto(
        idVehicle = 1,
        brand = "BMW",
        model = "3",
        year = 2019,
        color = Color.BLUE,
        mileage = 40000,
        typeAuto = TypeAuto.SEDAN
    )
    vehicleManager.addVehicle(auto1)

    val moto1 = Moto(
        idVehicle = 2,
        brand = "Yamaha",
        model = "5",
        year = 2015,
        color = Color.YELLOW,
        mileage = 20000,
        typeMoto = TypeMoto.SPORT
    )

    vehicleManager.addVehicle(moto1)

    val allVehicles = vehicleManager.getAllVehicle()
    allVehicles.forEach{ vehicle ->
        vehicle.getVehicleInfo()
    if(vehicle is Auto) {
        println(vehicle.typeAuto)
    }



    }





    val owner1 = Owner(
        idOwner = 1,
        name = "Иван",
        telephoneNumber = 89905578121,
        email = "google.ivan@gmail.com"
    )




    val ad1 = Ads(
        idAd = 1,
        price = 3000000,
        publicationDate = Date(),
        idOwner = owner1.idOwner,
        idVehicle = auto1.idVehicle
    )



}

fun menu() {
    println("1. Добавить новое ТС\n2. Добавить данные владельца\n3. Добавить объявление\n4. Снять объявление\n5. Поиск по объявлениям")
    val numberOfChoice = readln()
    if (numberOfChoiceCheck(numberOfChoice)) {
        val numberOfChoiceInt = numberOfChoice.toInt()
        when (numberOfChoiceInt) {
            1 -> {}
            2 -> {}
            3 -> {}
            4 -> {}
            5 -> {}
            else -> {}
        }

    }
}

fun numberOfChoiceCheck(enteredSymbol: String): Boolean {
    if (enteredSymbol.count() != 1) {
        println("Введите один символ в формате \"Цифра от 1 до 5\":")
        return false
    }
    if (enteredSymbol.toInt() in 1..5) {
        return true
    } else {
        print("Введите один символ в формате \"Цифра от 1 до 5\":")
        return false
    }
}