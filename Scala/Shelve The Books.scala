// https://www.hackerrank.com/contests/round-2-holiday-cup/challenges/shelve-the-books

object Solution {
    val fact = new Array[Long](1000001);
    val m = 1000000007;
    def main(args: Array[String]) {
        fact(0) = 1;
        for(i <- 1 until fact.size)fact(i) = fact(i-1) * i % m;
        val t = readInt;
        for(i <- 1 to t){
            val Array(n, k) = readLine.split(" ").map(_.toInt);
            if(n == k) println(3 * numWays(k) % m);
            else println(numWays(k));
        }
    }
    def numWays(k:Int):Long = {
        return BigInt(8).modPow(BigInt(k), BigInt(m)).toLong * fact(k) % m;
    }
}
