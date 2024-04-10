package managers

import data.Owner

class TestOwnerManager: OwnerManager {

    val ownerList = mutableListOf<Owner>()

    override fun addOwner (owner: Owner) {

        ownerList.add(owner)
    }

}