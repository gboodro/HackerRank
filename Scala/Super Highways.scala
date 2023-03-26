// https://www.hackerrank.com/contests/round-2-holiday-cup/challenges/super-highways

object Solution {
    def main(args: Array[String]) {
        val m = BigInt(1000000009);
        val t = readInt;
        for(i <- 1 to t){
            val Array(n, k, c) = readLine.split(" ").map(_.toLong);
            println(estCost(n, k, c) % m);
        }
    }
    def estCost(n:BigInt, k:BigInt, c:BigInt):BigInt = {
        return n * (n-1) * (n+1) / 6 * k + n * (n-1) / 2 * c;
    }
}
