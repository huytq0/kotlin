fun showSeats(listSeats: MutableList<MutableList<String>>) {
	println("\nCinema:")
	for (i in listSeats.indices) {
		for (j in listSeats[i].indices) {
			print(listSeats[i][j] + " ")
		}
		println("")
	}
	menu(listSeats)
}

fun initialSeats(listSeats: MutableList<MutableList<String>>) {
	println("\nEnter the number of rows: ")
	val row = readln().toInt()
	println("Enter the number of seats in each row: ")
	val col = readln().toInt()
	
	for (i in 0..row) {
		val rows = mutableListOf<String>()
		for (j in 0..col){
			if (i == 0) {
				if (j == 0) rows.add(" ") else rows.add("$j")
			} else {
				if (j == 0) rows.add("$i") else rows.add("S")
			}
		}
		listSeats.add(rows)
	}
}

fun resetSeats(listSeats: MutableList<MutableList<String>>) {
	for (i in listSeats.indices) {
		for (j in listSeats[i].indices) {
			if (listSeats[i][j] == "B") {
				listSeats[i][j] = "S"
			}
		}
	}
}

fun pickSeat(listSeats: MutableList<MutableList<String>>) {
	println("Enter a row number: ")
	val numberOfRow = readln().toInt()
	println("Enter a seat number in that row: ")
	val numberOfCol = readln().toInt()
	listSeats[numberOfRow][numberOfCol] = "B"
	ticketPrices(listSeats.size - 1, listSeats[0].size - 1, numberOfRow)
	menu(listSeats)
}

fun ticketPrices(row: Int, col: Int, numberOfRow: Int) {
	if (row * col < 60) {
		println("Ticket price: $10")
	} else {
		if (numberOfRow <= row / 2) {
			println("Ticket price: $10")
		} else {
			println("Ticket price: $8")
		}
	}
}

fun statistics(listSeats: MutableList<MutableList<String>>) {
	// Number tickets
	var numberTickets = 0.0
	for (i in listSeats.indices) {
		for (j in listSeats[i].indices) {
			if (listSeats[i][j] == "B") {
				numberTickets++
			}
		}
	}
	println("\nNumber of purchased tickets: " + numberTickets)
	
	// Percentage
	val percentage = numberTickets * 100 / (listSeats.size - 1) * (listSeats[0].size - 1)
	val formatPercentage = "%.2f".format(percentage)
	println("Percentage: " + formatPercentage)
	
	// Current income
	// Total income
	println(
		if (allSeat < 60) {
			"Total income: $" +  (listSeats.size - 1) * (listSeats[0].size - 1) *10 
		} else {
			"Total income: $" + (listSeats[0].size - 1) * (listSeats.size - 1) / 2 * 10 +  (allSeat - allSeat / 2) * 8)
		}
	)
	menu(listSeats)
}

fun menu(listSeats: MutableList<MutableList<String>>) {
	println("\n1. Show the seats")
	println("2. Buy a ticket")
	println("3. Statistics")
	println("0. Exit")
	when (readln().toInt()) {
		0    -> return
		1    -> showSeats(listSeats)
		2    -> pickSeat(listSeats)
		3    -> statistics(listSeats)
		else -> menu(listSeats)
	}
}

fun main() {
	val listSeats = mutableListOf<MutableList<String>>()
	initialSeats(listSeats)
	
	menu(listSeats)
}