// https://www.hackerrank.com/challenges/string-o-permute

import scala.annotation.tailrec;

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt;
      	for(i <- 1 to t) f(readLine);
    }
  
  	def f(t:String):Unit = {
      	var i = 0;
      	val tLen = t.length;
      	while(i < tLen-1){
          	print(t.charAt(i+1) +""+ t.charAt(i));
          	i+=2;
        }
      	println();
    }
  
}