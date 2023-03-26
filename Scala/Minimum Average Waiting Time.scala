// https://www.hackerrank.com/contests/w6/challenges/minimum-average-waiting-time

import scala.collection.mutable.SortedSet;
import scala.collection.mutable.HashMap;
object Solution{
    def main(a:Array[String]){
        var sSize = 0L;
        var map = new HashMap[Long, Int]();
        var s = SortedSet[Long]();
        var p = new Array[Tuple2[Long, Long]](readInt);
        for(i <- 0 until p.size){
            val t = readLine.split(" ").map(_.toLong);
            p(i) = Tuple2(t(0), t(1));
        }
        p = p.sortWith(_._1 < _._1);
        var i = 0;
        var sum = 0L;
        var start = 0L;
        while(i < p.size){
            while(i < p.size && p(i)._1 <= start){
                sum += start - p(i)._1;
                s += p(i)._2;
                if(map.contains(p(i)._2)){
                    map(p(i)._2) += 1;
                }else
                    map += (p(i)._2 -> 1);
                i += 1;
                sSize += 1;
            }
            if(s.isEmpty){
                start = p(i)._1 + p(i)._2;
                sum += p(i)._2;
                i += 1;
            }else{
                val t = s.head;
                sum += t * sSize;
                start += t;
                if(map(t) == 1){
                    s -= t;
                    map -= t;
                }else{
                    map(t) -= 1;
                }
                sSize -= 1;
            }
        }
        while(!s.isEmpty){
            val t = s.head;
            sum += t * sSize;
            start += t;
            if(map(t) == 1){
                s -= t;
                map -= t;
            }else{
                map(t) -= 1;
            }
            sSize -= 1;
        }
        println(sum / p.size);
    }
}