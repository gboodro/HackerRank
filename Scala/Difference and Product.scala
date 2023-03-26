// https://www.hackerrank.com/contests/infinitum9/challenges/difference-and-product

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(d, p) = readLine.split(" ").map(_.toInt);
            println(countPairs(d, p));
        }
    }
    
    def countPairs(d:Long, p:Long):Long = {
        if(d < 0) return 0;
        val sq = Math.sqrt(d*d+4*p).toLong;
        if(d*d + 4*p != sq*sq) return 0;
        var s = Set[Tuple2[Long, Long]]();
        var v = d+sq; 
        if(v % 2 == 0){
            val b = v/2;
            s += Tuple2(d+b, b);
            s += Tuple2(b-d, b);
        }
        v = d-sq; 
        if(v % 2 == 0){
            val b = v/2;
            s += Tuple2(d+b, b);
            s += Tuple2(b-d, b);
        }
        v = -d+sq; 
        if(v % 2 == 0){
            val b = v/2;
            s += Tuple2(d+b, b);
            s += Tuple2(b-d, b);
        }
        v = -d-sq; 
        if(v % 2 == 0){
            val b = v/2;
            s += Tuple2(d+b, b);
            s += Tuple2(b-d, b);
        }
        return s.filter(x => x._1 * x._2 == p && Math.abs(x._1 - x._2) == d).size;
    }
}