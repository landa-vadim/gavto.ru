package managers

import data.Ads

class TestAdsManager : AdsManager {

    val vehicleManager: TestVehicleManager = TestVehicleManager()

    val activeAdsList = mutableListOf<Ads>()
    val inActiveAdsList = mutableListOf<Ads>()

    override fun addAd(ad: Ads) {
        activeAdsList.add(ad)
    }

    override fun getAllAds() {
        for (i in activeAdsList) {
            vehicleManager.getVehicleByID(i.idVehicle)?.getVehicleInfo()
            i.getAdInfo()
        }
    }

    override fun removeAd(ad: Ads) {
        activeAdsList.remove(ad)
        inActiveAdsList.add(ad)
    }

    override fun searchAds() {

    }

}