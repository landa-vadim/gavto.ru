package data

import java.util.*
class PriceRecord (
    val date: Date,
    val price: Int
) {
    fun getLastPrice() {
        println("Актуальная цена: $price рублей")
    }
    fun getLastPriceForRemovedAd() {
        println("Последняя цена: $price рублей")
    }
    fun getPriceHistory() {
        println("Цена на дату: $date - $price рублей")
    }
}