// https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers

import scala.annotation.tailrec
    
object Solution {
    
    def fibonacci(n: Int): Int = {
        if(n == 1){
            0
        }else if(n == 2){
            1
        }else{
            @tailrec def fibonacciAcc(acc: Int, n: Int): Int = {
                if (n <= 1) acc
                else fibonacciAcc(fibonacci(n-1) + fibonacci(n-2), 0)
            }
            fibonacciAcc(0, n)
        }
  }

    def main(args: Array[String]) {
         /** This will handle the input and output**/
         println(fibonacci(readInt()))

    }
}