// https://www.hackerrank.com/challenges/dice-path

import scala.collection.mutable.HashMap;

object Solution {

    val nMap = Map[Tuple2[Int, Int], Tuple2[Int, Int]](
        (Tuple2(1,2) -> Tuple2(3,2)), (Tuple2(1,3) -> Tuple2(5,3)),
		(Tuple2(1,4) -> Tuple2(2,4)), (Tuple2(1,5) -> Tuple2(4,5)),
		(Tuple2(2,1) -> Tuple2(4,1)), (Tuple2(2,3) -> Tuple2(1,3)),
		(Tuple2(2,4) -> Tuple2(6,4)), (Tuple2(2,6) -> Tuple2(3,6)),
		(Tuple2(3,1) -> Tuple2(2,1)), (Tuple2(3,2) -> Tuple2(6,2)),
		(Tuple2(3,5) -> Tuple2(1,5)), (Tuple2(3,6) -> Tuple2(5,6)),
		(Tuple2(4,1) -> Tuple2(5,1)), (Tuple2(4,2) -> Tuple2(1,2)),
		(Tuple2(4,5) -> Tuple2(6,5)), (Tuple2(4,6) -> Tuple2(2,6)),
		(Tuple2(5,1) -> Tuple2(3,1)), (Tuple2(5,3) -> Tuple2(6,3)),
		(Tuple2(5,4) -> Tuple2(1,4)), (Tuple2(5,6) -> Tuple2(4,6)),
		(Tuple2(6,2) -> Tuple2(4,2)), (Tuple2(6,3) -> Tuple2(2,3)),
		(Tuple2(6,4) -> Tuple2(5,4)), (Tuple2(6,5) -> Tuple2(3,5)));
    
    val mMap = Map[Tuple2[Int, Int], Tuple2[Int, Int]](
        (Tuple2(1, 2) -> Tuple2(5, 1)), (Tuple2(1, 3) -> Tuple2(4, 1)),
		(Tuple2(1, 4) -> Tuple2(3, 1)), (Tuple2(1, 5) -> Tuple2(2, 1)),
		(Tuple2(2, 1) -> Tuple2(6, 2)), (Tuple2(2, 3) -> Tuple2(4, 2)),
		(Tuple2(2, 4) -> Tuple2(3, 2)), (Tuple2(2, 6) -> Tuple2(1, 2)),
		(Tuple2(3, 1) -> Tuple2(6, 3)), (Tuple2(3, 2) -> Tuple2(5, 3)),
		(Tuple2(3, 5) -> Tuple2(2, 3)),	(Tuple2(3, 6) -> Tuple2(1, 3)),
		(Tuple2(4, 1) -> Tuple2(6, 4)),	(Tuple2(4, 2) -> Tuple2(5, 4)),
		(Tuple2(4, 5) -> Tuple2(2, 4)),	(Tuple2(4, 6) -> Tuple2(1, 4)),
		(Tuple2(5, 1) -> Tuple2(6, 5)),	(Tuple2(5, 3) -> Tuple2(4, 5)),
		(Tuple2(5, 4) -> Tuple2(3, 5)),	(Tuple2(5, 6) -> Tuple2(1, 5)),
		(Tuple2(6, 2) -> Tuple2(5, 6)),	(Tuple2(6, 3) -> Tuple2(4, 6)),
		(Tuple2(6, 4) -> Tuple2(3, 6)),	(Tuple2(6, 5) -> Tuple2(2, 6)));
    
	var m = 0;
    var n = 0;
    val mem = HashMap[String, Int]();
	def main(args:Array[String]) = {
        val t = readInt;
        for(i <- 1 to t){
            val in = readLine.split(" ").map(_.toInt); 
            m = in(0);
		    n = in(1);
		    println(dp(1, 1, Tuple2(1, 2)));
        }
	}        
 
	def dp(x:Int, y:Int, cur:Tuple2[Int, Int]):Int = {
		val key = (m-x) + " " + (n-y) + " " + cur;
		if(!mem.contains(key)){
            val r = if(x < m){ dp(x+1, y, mMap(cur)) } else 0;
            val d = if(y < n){ dp(x, y+1, nMap(cur)) } else 0;
			mem += (key -> (cur._1 + Math.max(d, r)));
		}
		return mem(key);
	}

}