package es.horm.showcase.model

data class CounterModel(
    val currentCount: Int,
) {
    fun increase(amount: Int): CounterModel = copy(currentCount = currentCount+amount)
    fun decrease(amount: Int): CounterModel = copy(currentCount = currentCount-amount)
}
