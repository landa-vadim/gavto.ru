package managers

import data.Owner
import validators.InputValidator

interface OwnerManager {
    fun addOwner(owner: Owner)
    fun getAllOwners(): List<Owner>
    fun getOwnerFromList(validator: InputValidator): Owner?
}