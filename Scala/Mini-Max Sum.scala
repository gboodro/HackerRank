// https://www.hackerrank.com/challenges/mini-max-sum

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

    // Complete the miniMaxSum function below.
    def miniMaxSum(arr: Array[Int]) {
        val bigarr = arr.map(BigInt(_))
        println((bigarr.sum - bigarr.max) + " " + (bigarr.sum - bigarr.min))

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        miniMaxSum(arr)
    }
}
