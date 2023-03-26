// https://www.hackerrank.com/contests/projecteuler/challenges/euler063

object Solution {

    def main(args: Array[String]) {
        val n = readInt;
        var a = (Math.log(Math.pow(10, n-1))/Math.log(n)).toLong;
        while(BigInt(a).pow(n).toString.size >= n) a -= 1;
        while(BigInt(a).pow(n).toString.size < n) a += 1;
        while(BigInt(a).pow(n).toString.size == n){
            println(BigInt(a).pow(n));
            a += 1;
        }
    }
}