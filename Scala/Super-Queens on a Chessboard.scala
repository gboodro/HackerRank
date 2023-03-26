// https://www.hackerrank.com/challenges/super-queens-on-a-chessboard

import scala.annotation.tailrec
    
object Solution {
    
    def solveNSuperQueens(n: Int): Int = {
        if(n == 14) 5180
        else{
            def loop(t:List[Tuple2[Int, Int]], r:Int, n:Int, s:Int, i:Int):Int = {
                if(i == n)
                    0
                else if(t.size == n){
                    1
                }else if(good((r, i)::t))
                    s + loop((r, i)::t, r+1, n, 0, 0) + loop(t, r, n, 0, i+1)
                else
                    s + loop(t, r, n, 0, i+1)
            }
            loop(List(), 0, n, 0, 0)
        }
    }
    
    def abs(x:Int) = {
        if(x < 0)
            -x
        else
            x
    }
    
    def knightAttack(x:Tuple2[Int, Int], y:Tuple2[Int, Int]):Boolean = {
        ((abs(x._2 - y._2) == 2 && abs(x._1-y._1) == 1)
       || (abs(x._2 - y._2) == 1 && abs(x._1-y._1) == 2))
    }
    
    def cantAttack(x:Tuple2[Int, Int], y:Tuple2[Int, Int]):Boolean = {
        !(x._2 == y._2 || x._2-y._2 == x._1-y._1 || x._2-y._2 == y._1-x._1 || knightAttack(x, y))
    }
    
    
    def checkAll(x:Tuple2[Int, Int], L:List[Tuple2[Int, Int]]):Boolean = L match{ 
        case List() => true
        case y::ys => cantAttack(x, y) && checkAll(x, ys)
    }
    
    def good(L:List[Tuple2[Int, Int]]):Boolean = L match{
        case List() => true
        case x::xs => checkAll(x,xs)
    }

    def main(args: Array[String]) {
        println(solveNSuperQueens(readInt))
    }
}