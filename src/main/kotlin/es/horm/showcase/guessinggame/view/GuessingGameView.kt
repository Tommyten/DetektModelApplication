package es.horm.showcase.guessinggame.view

class GuessingGameView {
    fun printGreeting() {
        println("Welcome to the Guessing game")
        println("Guess a number between 0 and 100")
        println("0 <= your number <= 100")
    }

    fun takeGuess(amountOfGuessesYet: Int): Int {
        println("Take guess number ${amountOfGuessesYet+1}")
        var guess = readlnOrNull()?.toIntOrNull()
        while(guess == null) {
            println("Please type a number")
            guess = readlnOrNull()?.toIntOrNull()
        }
        return guess
    }

    fun printHigher() {
        println("The number to guess is higher")
    }

    fun printLower() {
        println("The number to guess is lower")
    }

    fun printWin(amountOfGuesses: Int) {
        println("You guessed the number correctly " +
                "after $amountOfGuesses guesses!")
    }

    fun askAgain(): Boolean {
        println("Type 'again' to play again")
        println("Type anything else to leave")
        return readlnOrNull() == "again"
    }
}
