// https://www.hackerrank.com/challenges/sherlock-and-the-maze

import scala.collection.mutable.HashMap;
object Solution{
    var mem = new HashMap[Tuple4[Int, Int, Int, Boolean], Long]();
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t){
            val Array(m, n, k) = readLine.split(" ").map(_.toInt);
            if(m * n != 1) println((f(m-1, n, k, true) + f(m, n-1, k, false)) % 1000000007L);
            else println(1);
        }
    }
    def f(t:Tuple4[Int, Int, Int, Boolean]):Long = {
        if(!mem.contains(t)){
            if(t._1 == 1 && t._2 == 1) return 1L;
            if(t._1 < 1 || t._2 < 1) return 0L;
            if(t._3 <= 0){
                if(t._1 != 1 && t._2 != 1) mem += (t -> 0L);
                if(t._4) mem += (t -> (f(t._1 - 1, t._2, 0, t._4) % 1000000007L));
                else     mem += (t -> (f(t._1, t._2 - 1, 0, t._4) % 1000000007L));
            }else{
                if(t._4) mem += (t -> (f(t._1-1, t._2, t._3, t._4) + f(t._1, t._2-1, t._3-1, !t._4))  % 1000000007L);
                else     mem += (t -> (f(t._1, t._2-1, t._3, t._4) + f(t._1-1, t._2, t._3-1, !t._4))  % 1000000007L);
            }
        }
        return mem(t);
    }
}