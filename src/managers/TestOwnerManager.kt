package managers

import data.Owner
import validators.InputValidator

class TestOwnerManager : OwnerManager {

    private val ownerList = mutableListOf<Owner>()
    val adsOwnerList = mutableListOf<Owner>()

    override fun addOwner(owner: Owner) {
        ownerList.add(owner)
    }
    override fun getOwnerFromList(validator: InputValidator): Owner {
        ownerList.forEachIndexed { index, owner ->
            println("${index + 1}.")
            owner.getOwnerInfo()
        }
        println("Найдите свои данные владельца в списке и введите соответствующий номер:")
        val choice = validator.isStringValidInRange(readln(), 1..ownerList.count())
        return ownerList[choice - 1]
    }
}