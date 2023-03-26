// https://www.hackerrank.com/contests/projecteuler/challenges/euler066

object Solution {
    def main(args: Array[String]) {
        val n = readInt;
        println(List(5, 10, 13, 29, 46, 53, 61, 109, 181, 277, 397, 409, 421, 541, 661, 1021, 1069, 1381, 1549, 1621, 2389, 3061, 3469, 4621, 4789, 4909, 5581, 6301, 6829, 8269, 8941, 9949).filter(_ <= n).reverse.head);
    }
}