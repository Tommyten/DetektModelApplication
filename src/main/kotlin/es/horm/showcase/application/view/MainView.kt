package es.horm.showcase.application.view

import es.horm.showcase.application.controller.ApplicationController
import kotlin.system.exitProcess

class MainView(
    private val applicationController: ApplicationController,
) {

    fun render() {
        println("Type 'Counter' to start the Counter program")
        println("Type 'Guessing Game' to start the Guessing Game")
        when(readlnOrNull()?.lowercase()) {
            "counter" -> applicationController.onCounterEntered()
            "guessing game" -> applicationController.onGuessingGameEntered()
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
