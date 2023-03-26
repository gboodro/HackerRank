// https://www.hackerrank.com/challenges/sherlock-and-queries

object Solution {
    
    val m = 1000000007L;
    
    def main(args:Array[String]){
        readLine;
        println(f(readLine.split(" ").map(_.toLong), readLine.split(" ").map(_.toLong).toList, readLine.split(" ").map(_.toLong).toList));
    }
    
    def f(a:Array[Long], b:List[Long], c:List[Long]):String = {
        val cond = compact(b.zip(c).sortWith(_._1 < _._1));
        for(t <- cond){
            val k = t._1;
            val v = t._2;
            for(i <- k-1 until a.size by k){
                a(i.toInt) *= v;
                a(i.toInt) %= m;
            }
        }
        return a.mkString(" ");
    }
    
    def compact(L:List[Tuple2[Long, Long]]):List[Tuple2[Long, Long]] = {
        def aux(cur:Tuple2[Long, Long], left:List[Tuple2[Long, Long]], acc:List[Tuple2[Long, Long]]):List[Tuple2[Long, Long]] = left match {
            case List() => return cur::acc;
            case x::xs  => if(cur._1 == x._1) return aux(Tuple2(cur._1, cur._2*x._2%m), xs, acc);
                           else return aux(x, xs, cur::acc);
        }
        return aux(L.head, L.tail, List());
    }
}