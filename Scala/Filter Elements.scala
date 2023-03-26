// https://www.hackerrank.com/challenges/filter-elements

import scala.collection.mutable.HashMap;

object Solution{
    def main(args:Array[String])={
        val t = readInt;
        for(i <- 1 to t){
            val in = readLine.split(" ").map(x => x.toInt);
            f(in(1), readLine.split(" ").map(x => x.toInt).toList);
        }
    }
    
    def f(k:Int, L:List[Int]):Unit = {
        val map = new HashMap[Int, Int]();
        for(i <- L){
            if(!map.contains(i)) map += (i -> 0);
            map(i) += 1;
        }
        val siz = map.keys.size;
        for(i <- L) if(map.contains(i) && map(i) >= k){
            print(i+" ");
            map -= i;
        }
        if(siz == map.keys.size) print("-1");
        println();
    }
    
}