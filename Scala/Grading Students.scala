// https://www.hackerrank.com/challenges/grading

import java.io.PrintWriter

object Solution {

    /*
     * Complete the gradingStudents function below.
     */
    def gradingStudents(grades: Array[Int]): Array[Int] = {
        /*
         * Write your code here.
         */
        grades.map(x => if(x > 37) (x + 2)/5*5 else x).zip(grades).map(y => Math.max(y._1, y._2))
    }

    def main(args: Array[String]) {
        val scan = scala.io.StdIn

        val fw = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = scan.readLine.trim.toInt

        val grades = Array.ofDim[Int](n)

        for (gradesItr <- 0 until n) {
            val gradesItem = scan.readLine.trim.toInt
            grades(gradesItr) = gradesItem}

        val result = gradingStudents(grades)

        fw.println(result.mkString("\n"))

        fw.close()
    }
}
