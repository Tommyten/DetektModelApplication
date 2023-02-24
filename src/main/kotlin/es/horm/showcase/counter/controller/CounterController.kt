package es.horm.showcase.counter.controller

import es.horm.showcase.application.controller.ApplicationController
import es.horm.showcase.common.controller.Controller
import es.horm.showcase.counter.model.CounterModel
import es.horm.showcase.counter.view.CounterView
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
