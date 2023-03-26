// https://www.hackerrank.com/challenges/matrix-rotation

import scala.collection.mutable.HashMap;

object Solution{

    def main(args:Array[String]) = {
        val in = readLine.split(" ").map(_.toInt);
        var arr = new Array[Array[Int]](in(0));
        for(i <- 1 to in(0)) 
            arr(i-1) = readLine.split(" ").map(_.toInt);
        println(rotate(arr, in(2)));
    }

    def rotate(arr:Array[Array[Int]], r:Int):String = {
        var b = Array.fill(arr.size){ new Array[Int](arr(0).size) };
        var m = arr.size;
        var n = arr(0).size;
        val min = Math.min(m/2, n/2);
        for(i <- 1 to min){
            val map = getMap(m, n);
            val len = map.keys.size;
            for(j <- map.keys){
                val cur = map(j);
                val next = map((j+r)%len);
                b(next._1 + i-1)(next._2 + i-1) = arr(cur._1 + i-1)(cur._2 + i-1);
            }
            m-=2;
            n-=2;
        }
        return b.map(x => x.mkString(" ")).mkString("\n");
    }

    def getMap(m:Int, n:Int):HashMap[Int, Tuple2[Int, Int]] = {
        var map = new HashMap[Int, Tuple2[Int, Int]]();
        val len = 2*(m+n-2)-1;
        for(i <- 0 to len) map += (i -> getLoc(i, m, n));
        return map;
    }

    def getLoc(i:Int, m:Int, n:Int):Tuple2[Int, Int] = {
        if(i < m-1) 
            return (i, 0);
        else if(i < m+n-2) 
            return (m-1, (i - m + 1) % n);
        else if(i < 2*m + n - 3) 
            return (2*m + n-3-i, n-1);
        else 
            return (0, 2*(m+n-2)-i);
    }
}