package es.horm.showcase.application.model

import es.horm.showcase.common.controller.Controller

data class ApplicationStateModel(
    val currentController: Controller
) {
    fun changeController(newController: Controller): ApplicationStateModel = copy(currentController = newController)
}
