// https://www.hackerrank.com/contests/w22/challenges/cookie-party

object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = BigInt(sc.nextInt());
        var m = BigInt(sc.nextInt());
        println((n - (m - m/n*n)) % n);
    }
}
