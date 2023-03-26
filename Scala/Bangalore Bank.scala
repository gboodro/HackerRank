// https://www.hackerrank.com/challenges/bangalore-bank

import scala.collection.mutable.HashMap;
object Solution{
    val dist = Array.fill(10){new Array[Int](10)};
    var a = Array[Int]();
    var n = 0;
    val mem = HashMap[Tuple3[Int, Int, Int], Int]();
    def main(args:Array[String]){
        for(i <- 1 to 9){
            dist(i)(0) = 10-i;
            dist(0)(i) = 10-i;
            for(j <- 1 to 9){
                dist(i)(j) = Math.abs(i-j);
            }
        }
        var min = 1000000000;
        n = readLine.toInt;
        a = readLine.split(" ").map(_.toInt);
        for(i <- 0 to 9){
            for(j <- i to 9){
                min = Math.min(getMin(i, j, 0), min);    
            }
        }
        println(min);
    }
    def getMin(t:Tuple3[Int, Int, Int]):Int = {
        if(t._3 == n)return 0;
        if(!mem.contains(t)){
            val c = a(t._3);
            val min1 = Math.min(t._2, c);
            val max1 = Math.max(t._2, c);
            val min2 = Math.min(t._1, c);
            val max2 = Math.max(t._1, c);
            val min = 1 + Math.min(getMin(min1, max1, t._3+1) + dist(t._1)(c), getMin(min2, max2, t._3+1) + dist(t._2)(c));
            mem += (t -> min);
        }
        return mem(t);
    }
}