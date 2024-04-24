package data

import managers.OwnerManager
import java.util.*

class Owner (
    val idOwner: UUID = UUID.randomUUID(),
    val name: String,
    val telephoneNumber: Long,
    val email: String,
) {



    fun getOwnerInfo () {
        println("Имя: $name\nНомер телефона: $telephoneNumber\nemail: $email")
    }

}