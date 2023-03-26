// https://www.hackerrank.com/challenges/subset-sum

import scala.annotation.tailrec

object Solution {
  
  def main(args:Array[String]) {
    val len = readLine.toInt - 1
    var a = readLine.split(" ").map(x => x.toLong).sortWith(_ > _)
    for(i <- 1 to len) a(i) += a(i-1)
    val t = readLine.toInt
    for(i <- 1 to t) println(minAux(a, readLine.toLong))
  }
  
  def minAux(sum:Array[Long], S:Long):Int = {
    if(S > sum(sum.size-1)) return -1
    else return binSearch(sum, S, sum.size/2, sum.size/2)
  }
  
  @tailrec
  def binSearch(arr:Array[Long], S:Long, i:Int, len:Int):Int = {
    if(S <= arr(i)) 
      if(i == 0 || S > arr(i-1)) return i+1
      else return binSearch(arr, S, i-(len+1)/2, len/2)
    else return binSearch(arr, S, i+(len+1)/2, len/2);
  }  
}