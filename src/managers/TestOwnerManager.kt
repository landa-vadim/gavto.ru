package managers

import data.Owner

class TestOwnerManager : OwnerManager {

    private val ownerList = mutableListOf<Owner>()

    override fun addOwner(owner: Owner) {
        ownerList.add(owner)
    }

    override fun getAllOwners(): List<Owner> {
        return ownerList
    }
}