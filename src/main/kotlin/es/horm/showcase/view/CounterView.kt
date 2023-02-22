package es.horm.showcase.view

import es.horm.showcase.controller.CounterController
import kotlin.system.exitProcess

class CounterView(
    private val counterController: CounterController
) {

    fun initialRender() {
        println("Welcome to the Counter")
        println("Type 'plus' to increase the counter by one")
        println("Type 'minus' to decrease the counter by one")
        renderView()
    }

    private fun renderView() {
        println("Current count is: ${counterController.currentCount.currentCount}")
        when(readlnOrNull()?.lowercase()) {
            "plus" -> counterController.onPlusEntered()
            "minus" -> counterController.onMinusEntered()
            "exit" -> counterController.onExitEntered()
            else -> exitProcess(1)
        }
    }

    fun onDataUpdated() {
        renderView()
    }
}
