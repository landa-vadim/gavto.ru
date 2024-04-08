class Owner (
    val idOwner: Int,
    val name: String,
    val telephoneNumber: Long,
    val email: String,
) {

    fun getOwnerInfo () {
        println("ID: $idOwner\nИмя: $name\nНомер телефона: $telephoneNumber\nemail: $email")
    }

}