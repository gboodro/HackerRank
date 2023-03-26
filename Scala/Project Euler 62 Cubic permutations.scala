// https://www.hackerrank.com/contests/projecteuler/challenges/euler062

import scala.collection.mutable.HashMap;
object Solution {
    def main(args: Array[String]) {
        val Array(n, k) = readLine.split(" ").map(_.toLong);
        val m = HashMap[String, Tuple2[Long, Int]]();
        for(i <- 1L until n){
            val c = i*i*i;
            val minLex = c.toString.toCharArray.sorted.mkString("");
            if(!m.contains(minLex)){
                m += (minLex -> Tuple2(c, 1));
            }else{
                m(minLex) = Tuple2(m(minLex)._1, m(minLex)._2+1);
            }
        }
        println(m.values.filter(_._2==k).map(_._1).toList.sorted.mkString("\n"));
    }
}