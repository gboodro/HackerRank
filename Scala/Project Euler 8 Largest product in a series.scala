// https://www.hackerrank.com/contests/projecteuler/challenges/euler008

import scala.collection.mutable.ListBuffer;
object Solution{
    def main(a:Array[String]){
        val t = readLine.toInt;
        for(i <- 1 to t){
            val k = readLine.split(" ").map(_.toInt);
            println(fSplit(k(1), readLine));
        }
    }
    
    def fSplit(k:Int, s:String):Long = {
        val spl = s.split("0");
        var max = 0L;
        for(t <- spl)
            max = Math.max(max, f(k, t.toCharArray.map(_.toLong-48)));
        return max;
    }
    
    def f(k:Int, a:Array[Long]):Long = {
        if(a.size < k) return 0;
        val L = new ListBuffer[Long]();
        var prod = 1L;
        for(i <- 0 until k){
            prod *= a(i);
            L += a(i);
        }
        var max = prod;
        for(i <- k until a.size){
            prod /= L.remove(0);
            prod *= a(i);
            L += a(i);
            max = Math.max(max, prod);
        }
        return max;
    }
    
}