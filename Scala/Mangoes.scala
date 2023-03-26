// https://www.hackerrank.com/challenges/mango

import scala.annotation.tailrec;

object Solution{
    
    def main(args:Array[String]){
        val Array(n, m) = readLine.split(" ").map(_.toLong);
        println(f(m, readLine.split(" ").map(_.toInt), readLine.split(" ").map(_.toInt)));
    }
    
    def f(m:Long, a:Array[Int], h:Array[Int]):Int = {
        val L = zip(a, h);
        @tailrec
        def ct(less:Int, great:Int):Int = {
            val mid = (less + great)/2;
            if(less+1 == great) 
                return less;
            else if(sumSort(mid, L) <= m)
                return ct(mid, great);
            else
                return ct(less, mid);
        }
        return ct(0, a.size+1);
    }    
    
    def zip(a:Array[Int], h:Array[Int]):List[Tuple2[Int, Int]] = {
        @tailrec
        def zipEm(i:Int, acc:List[Tuple2[Int, Int]]):List[Tuple2[Int, Int]] = {
            if(i == a.size) 
                return acc;
            else 
                return zipEm(i+1, Tuple2(a(i), h(i))::acc);
        }
        return zipEm(0, List());
    }
    def sumSort(i:Long, L:List[Tuple2[Int, Int]]):Long = {
        @tailrec
        def sumToI(cur:Long, v:List[Long], s:Long):Long = {
            if(cur == 0) 
                return s;
            else 
                return sumToI(cur-1, v.tail, v.head + s);
        }
        return sumToI(i, L.map(x => x._1 + x._2*(i-1)).sorted, 0);
    }
}