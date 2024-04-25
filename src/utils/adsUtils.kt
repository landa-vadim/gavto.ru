package utils

import data.Ads
import managers.AdsManager
import managers.TestAdsManager
import java.util.*

val adsManager: AdsManager = TestAdsManager()

fun getAdDate(): Date {

    val date = Date()
    return date
}

fun getAdPrice(): Int {

    var price = 0
    do {
        println("Введите цену:")
        price = validator.isStringValidInRange(readln(), 1..99999999)
    } while (price == 0)
    return price
}

