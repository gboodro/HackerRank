// https://www.hackerrank.com/challenges/strange-grid/problem

object Solution {

    def main(args: Array[String]) {
        val Array(r, c) = readLine.split(" ").map(_.toLong-1);
        println(r/2*2*5+2*c+r%2);
    }
}