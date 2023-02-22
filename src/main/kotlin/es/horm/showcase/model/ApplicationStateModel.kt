package es.horm.showcase.model

import es.horm.showcase.controller.Controller

data class ApplicationStateModel(
    val currentController: Controller
) {
    fun changeController(newController: Controller): ApplicationStateModel = copy(currentController = newController)
}
