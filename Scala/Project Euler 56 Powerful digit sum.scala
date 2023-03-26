// https://www.hackerrank.com/contests/projecteuler/challenges/euler056

object Solution {

    def main(args: Array[String]) {
        var max = 0L;
        val n = readInt;
        for(a <- 1 until n){
            for(b <- 1 until n){
                max = Math.max(max, dSum(BigInt(a).pow(b)));
            }
        }
        println(max);
    }
    def dSum(n:BigInt):Long = {
        var s = 0L;
        var a = n;
        while(a > 0){
            s += (a%10).toLong;
            a /= 10;
        }
        return s;
    }
}