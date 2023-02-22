package es.horm.showcase.controller

import es.horm.showcase.model.ApplicationStateModel
import es.horm.showcase.model.CounterModel
import es.horm.showcase.view.MainView
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
}
