package es.horm.showcase.view

import es.horm.showcase.controller.ApplicationController
import kotlin.system.exitProcess

class MainView(
    private val applicationController: ApplicationController,
) {

    fun render() {
        println("Type 'Counter' to enter the Counter program")
        when(readlnOrNull()?.lowercase()) {
            "counter" -> applicationController.onCounterEntered()
            "exit" -> exitProcess(0)
            else -> exitProcess(1)
        }
    }

    fun onDataUpdated() {
        if(applicationController.currentApplicationStateModel.currentController is ApplicationController) {
            render()
        }
    }
}
