// https://www.hackerrank.com/contests/w13/challenges/sherlock-and-anagrams

import scala.collection.mutable.HashMap;
object Solution {
    
    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t)
            println(getMap(readLine));
    }
    
    def getMap(a:String):Long = {
        val ct = HashMap[String, Long]();
        for(i <- 0 until a.size){
            for(j <- i+1 to a.size){
                val cur = a.substring(i, j).toCharArray.toList.sorted.mkString("");
                if(ct.contains(cur)) ct(cur) += 1;
                else ct += (cur -> 1L);
            }
        }
        return ct.values.map(x => x*(x-1)/2).foldLeft(0L)(_+_);
    }
}