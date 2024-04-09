import data.*
import managers.TestVehicleManager
import managers.VehicleManager
import org.w3c.dom.css.Counter
import java.util.Date

fun main() {

    mainMenu()

    createVehicleForSearch()

    val vehicleManager: VehicleManager = TestVehicleManager()


    val auto1 = Auto(
        idVehicle = 1,
        brand = "BMW",
        model = "3",
        year = 2019,
        color = "Blue",
        mileage = 40000,
        typeAuto = TypeAuto.SEDAN
    )
    vehicleManager.addVehicle(auto1)

    val moto1 = Moto(
        idVehicle = 2,
        brand = "Yamaha",
        model = "5",
        year = 2015,
        color = "Yellow",
        mileage = 20000,
        typeMoto = TypeMoto.SPORT
    )

    vehicleManager.addVehicle(moto1)

    val allVehicles = vehicleManager.getAllVehicle()
    allVehicles.forEach { vehicle ->
        vehicle.getVehicleInfo()
        if (vehicle is Auto) {
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

fun search(usersChoice: Int) {

}


fun mainMenu(): Boolean {
    val vehicleManager: VehicleManager = TestVehicleManager()
    println("1. Добавить новое ТС\n2. Добавить данные владельца\n3. Добавить объявление\n4. Снять объявление\n5. Поиск по объявлениям")
    val numberOfChoice = enteredSymbolCheck(readln())
    if (numberOfChoice == 1) {
        vehicleConstructor()
    }
    if (numberOfChoice == 2) {

    }
    if (numberOfChoice == 3) {

    }
    if (numberOfChoice == 4) {

    }
    if (numberOfChoice == 5) {

    }
}


fun enteredSymbolCheck(enteredSymbol: String): Int {

    if (enteredSymbol.count() != 1) {
        println("Введите один символ в формате \"Цифра от 1 до 5\":")
        return 0
    }
    val correctSymbols = listOf('1', '2', '3', '4', '5')
    if (correctSymbols.contains(enteredSymbol[0])) {
        when (enteredSymbol[0].digitToInt()) {
            1 -> {
                return 1
            }

            2 -> {
                return 2
            }

            3 -> {
                return 3
            }

            4 -> {
                return 4
            }

            5 -> {
                return 5
            }

            else -> return 0
        }
    } else {
        print("Введите один символ в формате \"Цифра от 1 до 5\":")
        return 0
    }
}

fun vehicleConstructor(): Boolean {
    val vehicleManager: VehicleManager = TestVehicleManager()
    println("1. Добавить автомобиль\n2. Добавить мотоцикл\n3. Добавить коммерческий авто\n4. Назад")
    val choiceType = enteredSymbolCheck(readln())
    if (listOf(1, 2, 3).contains(choiceType)) {
        println("Введите марку:")
        val enteredBrand = readln()
        println("Введите модель:")
        val enteredModel = readln()
        println("Введите год выпуска:")
        val enteredYear = readln().toInt()
        println("Введите цвета через запятую:")
        val enteredColor = readln()
        println("Введите верхнюю границу пробега:")
        val enteredMaxMileage = readln().toInt()
        if (choiceType == 1) {
            println("Выберете тип кузова:\n1. Седан\n 2. Хэтчбэк\n3. Универсал")
            val enteredTypeAuto: TypeAuto
            val enteredSymbol = readln().toInt()
            enteredTypeAuto =
                when (enteredSymbol) {
                    1 -> TypeAuto.SEDAN
                    2 -> TypeAuto.HATCHBACK
                    3 -> TypeAuto.UNIVERSAL
                    else -> TypeAuto.UNKNOWN
                }
            val vehicle = Auto(
                1,
                enteredBrand,
                enteredModel,
                enteredYear,
                enteredColor,
                enteredMaxMileage,
                enteredTypeAuto
            )
            vehicleManager.addVehicle(vehicle)
            return true
        }
        if (choiceType == 2) {
            println("Выберете тип мотоцикла:\n1. Кроссовый\n2. Спортивный\n3. Грантуризмо")
            val enteredTypeMoto: TypeMoto
            val enteredSymbol = readln().toInt()
            enteredTypeMoto =
                when (enteredSymbol) {
                    1 -> TypeMoto.CROSS
                    2 -> TypeMoto.SPORT
                    3 -> TypeMoto.GRANTURISMO
                    else -> TypeMoto.UNKNOWN
                }
            val vehicle = Moto(
                1,
                enteredBrand,
                enteredModel,
                enteredYear,
                enteredColor,
                enteredMaxMileage,
                enteredTypeMoto
            )
            vehicleManager.addVehicle(vehicle)
            return true
        }
        if (choiceType == 3) {
            println("Введите грузоподъемность:")
            val enteredLoadCapacity = readln().toDouble()
            val vehicle = Commercial(
                1,
                enteredBrand,
                enteredModel,
                enteredYear,
                enteredColor,
                enteredMaxMileage,
                enteredLoadCapacity
            )
            vehicleManager.addVehicle(vehicle)
            return true
        } else return false
    } else return false
}