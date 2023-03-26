// https://www.hackerrank.com/challenges/plus-minus

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

    // Complete the plusMinus function below.
    def plusMinus(arr: Array[Int]) {
        println(1.0 * arr.filter(_ > 0).size / arr.size)
        println(1.0 * arr.filter(_ < 0).size / arr.size)
        println(1.0 * arr.filter(_ == 0).size / arr.size)
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        plusMinus(arr)
    }
}
