package machine

class CoffeeMachine {
	// coffeeMachine {water, milk, coffee beans, cups, money}
	val coffeeMachine = mutableListOf<Int>(400, 540, 120, 9, 550)
	
	fun showCoffeeMachine(coffeeMachine: MutableList<Int>) {
		println("\nThe coffee machine has:")
		println("${coffeeMachine[0]} ml of water")
		println("${coffeeMachine[1]} ml of milk")
		println("${coffeeMachine[2]} g of coffee beans")
		println("${coffeeMachine[3]} disposable cups")
		println("$${coffeeMachine[4]} of money")
	}

	fun buy(coffeeMachine: MutableList<Int>) {
		println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
		when (readln()) {
			"1" -> { // espresso
				if (coffeeMachine[0] < 250) {
					println("Sorry, not enough water!")
					return
				}
				if (coffeeMachine[2] < 16) {
					println("Sorry, not enough coffee beans!")
					return
				}
				if (coffeeMachine[3] < 1) {
					println("Sorry, not enough disposable cups!")
					return
				}
				coffeeMachine.set(0, coffeeMachine[0] - 250)
				coffeeMachine.set(2, coffeeMachine[2] - 16)
				coffeeMachine.set(3, coffeeMachine[3] - 1)
				coffeeMachine.set(4, coffeeMachine[4] + 4)
				println("I have enough resources, making you a coffee!")
			}
			"2" -> { // latte
				if (coffeeMachine[0] < 350) {
					println("Sorry, not enough water!")
					return
				}
				if (coffeeMachine[1] < 75) {
					println("Sorry, not enough milk!")
					return
				}
				if (coffeeMachine[2] < 20) {
					println("Sorry, not enough coffee beans!")
					return
				}
				if (coffeeMachine[3] < 1) {
					println("Sorry, not enough disposable cups!")
					return
				}
				coffeeMachine.set(0, coffeeMachine[0] - 350)
				coffeeMachine.set(1, coffeeMachine[1] - 75)
				coffeeMachine.set(2, coffeeMachine[2] - 20)
				coffeeMachine.set(3, coffeeMachine[3] - 1)
				coffeeMachine.set(4, coffeeMachine[4] + 7)
				println("I have enough resources, making you a coffee!")
			}
			"3" -> { // cappuccino
				if (coffeeMachine[0] < 200) {
					println("Sorry, not enough water!")
					return
				}
				if (coffeeMachine[1] < 100) {
					println("Sorry, not enough milk!")
					return
				}
				if (coffeeMachine[2] < 12) {
					println("Sorry, not enough coffee beans!")
					return
				}
				if (coffeeMachine[3] < 1) {
					println("Sorry, not enough disposable cups!")
					return
				}
				coffeeMachine.set(0, coffeeMachine[0] - 200)
				coffeeMachine.set(1, coffeeMachine[1] - 100)
				coffeeMachine.set(2, coffeeMachine[2] - 12)
				coffeeMachine.set(3, coffeeMachine[3] - 1)
				coffeeMachine.set(4, coffeeMachine[4] + 6)
				println("I have enough resources, making you a coffee!")
			}
			"back" -> return
			else -> {
				println("Wrong input!")
				buy(coffeeMachine)
			}
		}
	}

	fun fill(coffeeMachine: MutableList<Int>) {
		fun addWater(coffeeMachine: MutableList<Int>) {
			println("\nWrite how many ml of water you want to add:")
			coffeeMachine.set(0, coffeeMachine[0] + readln().toInt())
		}
		fun addMilk(coffeeMachine: MutableList<Int>) {
			println("Write how many ml of milk you want to add:")
			coffeeMachine.set(1, coffeeMachine[1] + readln().toInt())
		}
		fun addCoffeeBeans(coffeeMachine: MutableList<Int>) {
			println("Write how many grams of coffee beans you want to add:")
			coffeeMachine.set(2, coffeeMachine[2] + readln().toInt())
		}
		fun addCups(coffeeMachine: MutableList<Int>) {
			println("Write how many disposable cups you want to add:")
			coffeeMachine.set(3, coffeeMachine[3] + readln().toInt())
		}
		
		try {
			addWater(coffeeMachine)
		} catch (e: Exception) {
			println("Wrong Input")
			addWater(coffeeMachine)
		}
		
		try {
			addMilk(coffeeMachine)
		} catch (e: Exception) {
			println("Wrong Input")
			addMilk(coffeeMachine)
		}
		
		try {
			addCoffeeBeans(coffeeMachine)
		} catch (e: Exception) {
			println("Wrong Input")
			addCoffeeBeans(coffeeMachine)
		}
		
		try {
			addCups(coffeeMachine)
		} catch (e: Exception) {
			println("Wrong Input")
			addCups(coffeeMachine)
		}
	}

	fun take(coffeeMachine: MutableList<Int>) {
		println("\nI gave you $${coffeeMachine[4]}")
		coffeeMachine.set(4, 0)
	}

	fun writeAction(coffeeMachine: MutableList<Int>) {
		println("Write action (buy, fill, take, remaining, exit):")
		when (readln()) {
			"buy" -> {
				buy(coffeeMachine)
				println()
				writeAction(coffeeMachine)
			}
			"fill" -> {
				fill(coffeeMachine)
				println()
				writeAction(coffeeMachine)
			}
			"take" -> {
				take(coffeeMachine)
				println()
				writeAction(coffeeMachine)
			}
			"remaining" -> {
				showCoffeeMachine(coffeeMachine)
				println()
				writeAction(coffeeMachine)
			}
			"exit" -> return
			else -> {
				println("Wrong input!")
				writeAction(coffeeMachine)
			}
		}
	}
	
	init {
		writeAction(coffeeMachine)	
	}
}

fun main() {
	val machine = CoffeeMachine()
}
