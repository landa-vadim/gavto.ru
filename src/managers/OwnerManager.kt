package managers

import data.Owner

interface OwnerManager {
    fun addOwner(owner: Owner)
    fun getOwnerFromList(): Owner
}