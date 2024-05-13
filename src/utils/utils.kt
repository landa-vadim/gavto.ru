package utils

import data.Ads
import data.Owner
import data.PriceRecord
import data.RemovedAds

fun printAllAds(activeAdsList: List<Ads>) {
    activeAdsList.forEachIndexed { index, ad ->
        println("${index + 1}.")
        ad.printAdInfo()
    }
}

fun Ads.printAdInfo() {
    val count = priceHistory.count()
    val lastIndex = count - 1
    owner.printOwnerInfo()
    vehicle.getVehicleInfo()
    if (count > 1) {
        println("История изменение цены:")
        priceHistory.forEach { price ->
            price.printPriceHistory()
        }
        priceHistory[lastIndex].printLastPrice()
    } else priceHistory[0].printLastPrice()
    println("----------------------------------------------------------------")
}

fun RemovedAds.printRemovedAdInfo() {
    val owner = ad.owner
    val vehicle = ad.vehicle
    val priceHistory = ad.priceHistory
    val count = priceHistory.count()
    val lastIndex = count - 1
    owner.printOwnerInfo()
    vehicle.getVehicleInfo()
    if (count > 1) {
        println("История изменение цены:")
        priceHistory.forEach { price ->
            price.printPriceHistory()
        }
        priceHistory[lastIndex].printLastPriceForRemovedAd()
    } else priceHistory[0].printLastPriceForRemovedAd()
    println("----------------------------------------------------------------")
}

fun RemovedAds.printReasonToRemoveAd() {
    println("Объявление")
    printRemovedAdInfo()
    println("Снято по причине:\n$reason")
}

fun printAllRemovedAds(inActiveAdsList: List<RemovedAds>) {
    inActiveAdsList.forEachIndexed { index, removedAd ->
        println("${index + 1}.")
        removedAd.printReasonToRemoveAd()
    }
}

fun PriceRecord.printLastPrice() {
    println("Актуальная цена: $price рублей")
}

fun PriceRecord.printLastPriceForRemovedAd() {
    println("Последняя цена: $price рублей")
}

fun PriceRecord.printPriceHistory() {
    println("Цена на дату: $date - $price рублей")
}

fun Owner.printOwnerInfo() {
    println("Имя: $name\nНомер телефона: $telephoneNumber\nemail: $email")
}

