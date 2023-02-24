package es.horm.showcase.guessinggame.controller

import es.horm.showcase.application.controller.ApplicationController
import es.horm.showcase.common.controller.Controller
import es.horm.showcase.guessinggame.view.GuessingGameView

class GuessingGameController(
    private val applicationController: ApplicationController
) : Controller {

    private companion object {
        private const val UPPER_BOUND = 100
    }

    private var numberToGuess = (0..UPPER_BOUND).random()

    private val guessingGameView = GuessingGameView()

    private var amountOfGuesses = 0

    fun startGuessingGame() {
        var again = true
        while(again) {
            guessingGameView.printGreeting()
            var guess = guessingGameView.takeGuess(amountOfGuesses)
            while (guess != numberToGuess) {
                if(guess < numberToGuess) guessingGameView.printHigher()
                else guessingGameView.printLower()
                amountOfGuesses += 1
                guess = guessingGameView.takeGuess(amountOfGuesses)
            }
            guessingGameView.printWin(amountOfGuesses)
            again = guessingGameView.askAgain()
            if(again) {
                numberToGuess = (0..UPPER_BOUND).random()
            }
        }
        applicationController.onExitEntered()
    }
}
