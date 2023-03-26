// https://www.hackerrank.com/contests/w28/challenges/boat-trip

object Solution {

    def main(args: Array[String]) {
        val Array(n, m, c) = readLine.split(" ").map(_.toInt);
        var maxC = m*c;
        println(Map(true -> "Yes", false -> "No")(readLine.split(" ").map(_.toInt).max <= maxC))
    }
}
