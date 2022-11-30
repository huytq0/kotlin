fun showSheet(str: MutableList<String>) {
	println("---------")
	println("| ${str[1]} ${str[2]} ${str[3]} |")
	println("| ${str[4]} ${str[5]} ${str[6]} |")
	println("| ${str[7]} ${str[8]} ${str[9]} |")
	println("---------")
}

fun scanSheet(str: MutableList<String>): String {
	for (i in 2..4  step 2) {
		if (str[5-i] == str[5] && str[5+i] == str[5] && (str[5] == "X" || str[5] == "O")) {
			return "${str[5]} wins"
		}
	}
	for (i in 1..3) {
		if (str[i] == str[i+3] && str[i] == str[i+6] && (str[i] == "X" || str[i] == "O")) {
			return "${str[i]} wins"
		}
	}
	for (i in 1..7 step 3) {
		if (str[i] == str[i+1] && str[i] == str[i+2] && (str[i] == "X" || str[i] == "O")) {
			return "${str[i]} wins"
		}
	}
	return "0"
}

fun selectCell(z: String, str: MutableList<String>) {
	try {
		val selectRowCol = readln().split(" ")
		// if (selectRowCol.size > 2) {
			// println("Enter row and col. Ex: 1 1")
			// selectCell(z, str)
			// return
		// }
		val x = selectRowCol[0].toInt()
		val y = selectRowCol[1].toInt()

		if (y in 1..3) {
			when (x) {
				1 -> {
					if (str[y] == " ") 
						str[y] = z
					else {
						println("This cell is occupied! Choose another one!")
						selectCell(z, str)
					}
				}
				2 -> {
					if (str[y+3] == " ") 
						str[y+3] = z
					else {
						println("This cell is occupied! Choose another one!")
						selectCell(z, str)
					}
				}
				3 -> {
					if (str[y+6] == " ") 
						str[y+6] = z
					else {
						println("This cell is occupied! Choose another one!")
						selectCell(z, str)
					}
				}
				else -> {
					println("Coordinates should be from 1 to 3!")
					selectCell(z, str)
				}
			}
		} else {
			println("Coordinates should be from 1 to 3!")
			selectCell(z, str)
		}
	} catch (e: Exception) {
		println("You should enter numbers!")
		selectCell(z, str)
	}
}

fun main() {
	val str = ("         ").split("").toMutableList()
	showSheet(str)
	
	repeat(4) {
		selectCell("X", str)
		showSheet(str)
		if (scanSheet(str) != "0") {
			println(scanSheet(str))
			return
		}
		selectCell("O", str)
		showSheet(str)
		if (scanSheet(str) != "0") {
			println(scanSheet(str))
			return
		}
	}
	selectCell("X", str)
	showSheet(str)
	if (scanSheet(str) != "0") println(scanSheet(str)) else println("Draw")
}