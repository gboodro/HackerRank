// https://www.hackerrank.com/contests/w11/challenges/sherlock-and-square

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t)println((BigInt(2).modPow(BigInt(readInt+1), BigInt(1000000007L))+2) % 1000000007L);
    }
}