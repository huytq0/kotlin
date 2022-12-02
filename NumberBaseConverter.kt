class NumberBaseConverter {
	fun toDec(n: Int, target: Int): String {
		var result: String = ""
		var remain: String = ""
		var number = n
		when (target) {
			in 2..9 -> {
				while (number != 0) {
					var q = number % target
					number /= target
					remain += q
				}
			} 
			in 10..36 -> {
				while (number != 0) {
					var q = if (number % target < 10) (number % 16 + target + 32) else (number % 16 + target + 39)
					number /= 16
					remain += q.toChar()
				}
			}
		}
		for (i in remain.length - 1 downTo 0) {
			result += remain[i]
		}
		return result
	}
	
	// Binary Convert
	fun binToDec(n: String): String {
		val bin = n.map(Character::getNumericValue)
		var result: Int = 0
		var d: Int = 1
		for (i in bin.size-1 downTo 0) {
			result += bin[i] * d
			d *= 2
		}
		return "$result"
	}
	
	
	fun decConvert(): String {
		print("Enter number in decimal system: ")
		val n = readln().toInt()
		print("Enter target base: ")
		when (readln()) {
			"2" -> return "Conversion result: " + decToBin(n)
			"8" -> return "Conversion result: " + decToOct(n)
			"16" -> return "Conversion result: " + decToHex(n)
			else -> {
				println("Wrong input!")
				//println(decConvert())
				return decConvert()
			}
		}
	}
	
	fun convertDec(): String {
		print("Enter source number: ")
		val n = readln()
		print("Enter source base: ")
		when (readln()) {
			"2" -> return "Conversion to decimal result: " + binToDec(n)
			"8" -> return "Conversion to decimal result: " + octToDec(n)
			"16" -> return "Conversion to decimal result: " + hexToDec(n)
			else -> {
				println("Wrong input!")
				//println(convertDec())
				return convertDec()
			}
		}
	}
	
	init {
		println("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
		when (readln()) {
			"10 2" -> {
			
			}
			"10 8" -> {
			
			}
			"10 16" -> {
			
			}
			"2 10" -> {
			
			}
			"/exit" -> print("")
			else -> {
				NumberBaseConverter()
			}
		}
		
	}
}  

fun main() {
	NumberBaseConverter()
}