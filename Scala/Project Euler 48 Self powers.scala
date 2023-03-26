// https://www.hackerrank.com/contests/projecteuler/challenges/euler048

object Solution {

    def main(args: Array[String]) {
        var s = BigInt(0);
        val n = readInt;
        val m = BigInt(10000000000L);
        for(i <- 1 to n){
            s = (s + BigInt(i).modPow(BigInt(i), m)) % m;
        }
        println(s);
    }
}