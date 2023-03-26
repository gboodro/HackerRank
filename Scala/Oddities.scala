// https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/oddities

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        val parMap = Map(0 -> " is even", 1 -> " is odd");
        for(i <- 1 to t){
            val n = readInt;
            println(n + parMap(n & 1));
        }
    }
}