package managers

import data.Owner
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import validators.InputValidator
import java.io.File

class JsonOwnerManager : OwnerManager {
    private val file = File("owners.json")
    private val ownerList = loadOwner()

    private fun saveOwner(list: MutableList<Owner>) {
        val data = Json.encodeToString(list)
        file.writeText(data)
    }

    private fun loadOwner(): MutableList<Owner> {
        val json = file.readText()
        val data = Json.decodeFromString<MutableList<Owner>>(json)
        return data
    }

    override fun addOwner(owner: Owner) {
        ownerList.add(owner)
        saveOwner(ownerList)
    }

    override fun getAllOwners(): List<Owner> {
        return ownerList
    }

}