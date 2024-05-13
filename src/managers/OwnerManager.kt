package managers

import data.Owner

interface OwnerManager {
    fun addOwner(owner: Owner)
    fun getAllOwners(): List<Owner>

}