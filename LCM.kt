import java.math.*

fun gcd(a: BigInteger, b: BigInteger): BigInteger {
	if (b == 0.toBigInteger()) return a
	return gcd(b, b % a)
}

fun lcm(a: BigInteger, b: BigInteger): BigInteger {
	println(gcd(a, b))
	return (a / gcd(a, b)) * b
}

fun main() {
    // write your code here
    val a = readln().toBigInteger()
    val b = readln().toBigInteger()
	println(lcm(a, b))
}