package es.horm.showcase.application.controller

import es.horm.showcase.counter.controller.CounterController
import es.horm.showcase.application.model.ApplicationStateModel
import es.horm.showcase.counter.model.CounterModel
import es.horm.showcase.application.view.MainView
import es.horm.showcase.common.controller.Controller
import es.horm.showcase.guessinggame.controller.GuessingGameController
import kotlin.properties.Delegates

class ApplicationController : Controller {
    private val view = MainView(this)

    var currentApplicationStateModel by Delegates.observable(ApplicationStateModel(this)) { _, _, _ ->
        view.onDataUpdated()
    }

    init {
        view.render()
    }

    fun onCounterEntered() {
        currentApplicationStateModel = currentApplicationStateModel.changeController(
            CounterController(CounterModel(0), this)
        )
    }

    fun onExitEntered() {
        currentApplicationStateModel = currentApplicationStateModel.changeController(this)
    }

    fun onGuessingGameEntered() {
        currentApplicationStateModel = currentApplicationStateModel.changeController(
            GuessingGameController(this).also { it.startGuessingGame() }
        )
    }
}
