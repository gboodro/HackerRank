// https://www.hackerrank.com/challenges/restaurant

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(a, b) = readLine.split(" ").map(x => BigInt(x));
            val g = a.gcd(b);
            println(a*b / g / g);
        }
    }
}