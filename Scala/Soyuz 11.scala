// https://www.hackerrank.com/contests/indeed-prime-challenge-june-2015/challenges/soyuz-11

object Solution {

    def main(args: Array[String]) {
        val n = readInt;
        println("  /\\\n" + List().padTo(n, "  ||\n").mkString("") + " /||\\\n/:||:\\\n" + List().padTo(n-1, "|:||:|\n").mkString("") + "|/||\\|\n  **\n  **")
    }
}