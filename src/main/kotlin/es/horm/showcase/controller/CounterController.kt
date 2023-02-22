package es.horm.showcase.controller

import es.horm.showcase.model.CounterModel
import es.horm.showcase.view.CounterView
import kotlin.properties.Delegates

class CounterController(
    counterModel: CounterModel,
    private val applicationController: ApplicationController
) : Controller {
    private val view: CounterView = CounterView(this)

    var currentCount by Delegates.observable(counterModel) { _, _, _ ->
        view.onDataUpdated()
    }

    init {
        view.initialRender()
    }

    fun onPlusEntered() {
        currentCount = currentCount.increase(1)
    }

    fun onMinusEntered() {
        currentCount = currentCount.decrease(1)
    }

    fun onExitEntered() {
        applicationController.onExitEntered()
    }
}
