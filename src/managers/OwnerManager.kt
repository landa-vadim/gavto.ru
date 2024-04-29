package managers

import data.Owner
import validators.InputValidator

interface OwnerManager {
    fun addOwner(owner: Owner)
    fun getOwnerFromList(validator: InputValidator): Owner
}