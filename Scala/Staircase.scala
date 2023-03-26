// https://www.hackerrank.com/challenges/staircase

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

    // Complete the staircase function below.
    def staircase(n: Int) {
        def repeat(c:Char, i:Int):String = i match {
            case 1 => c+"";
            case _ => repeat(c, i-1) + c
        }
        def curStair(s:Int):String = s match {
            case `n` => repeat('#', s)
            case _ => repeat(' ', n-s) + repeat('#', s)
        }
        def buildSteps(a:Int):String = a match {
            case 1 => curStair(a)
            case _ => buildSteps(a-1) + "\n" + curStair(a)
        }
        println(buildSteps(n))
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        staircase(n)
    }
}
