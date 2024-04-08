class Owner (
    val idOwner: Int,
    val name: String,
    val telephoneNumber: Long,
    val email: String,
): OwnerManager {

    val id = idOwner

    fun getOwnerInfo () {
        println("ID: $id\nИмя: $name\nНомер телефона: $telephoneNumber\nemail: $email")
    }

}