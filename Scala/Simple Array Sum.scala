// https://www.hackerrank.com/challenges/simple-array-sum

import java.io.PrintWriter

object Solution {

    /*
     * Complete the simpleArraySum function below.
     */
    def simpleArraySum(ar: Array[Int]): Int = {
        /*
         * Write your code here.
         */
        return ar.sum
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val arCount = stdin.readLine.trim.toInt

        val ar = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = simpleArraySum(ar)

        printWriter.println(result)

        printWriter.close()
    }
}
