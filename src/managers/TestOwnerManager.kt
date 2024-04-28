package managers

import data.Owner
import validators.InputValidator

class TestOwnerManager : OwnerManager {
    val validator = InputValidator()
    private val ownerList = mutableListOf<Owner>()
    val adsOwnerList = mutableListOf<Owner>()

    override fun addOwner(owner: Owner) {
        ownerList.add(owner)
    }
    override fun getOwnerFromList(): Owner {
        var number = 1
        var choice = 0
        ownerList.forEach { owner ->
            println("${number++}.")
            owner.getOwnerInfo()
        }
        println("Найдите свои данные владельца в списке и введите соответствующий номер:")
        choice = validator.isStringValidInRange(readln(), 1..ownerList.count())
        return ownerList[choice - 1]
    }
}