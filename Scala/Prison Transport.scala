// https://www.hackerrank.com/challenges/prison-transport

import scala.annotation.tailrec;
object Solution{
    def main(args:Array[String]){
        val arr = new Array[Set[Int]](readInt);
        for(i <- 0 to arr.size-1) arr(i) = Set(i);
        val minInd = new Array[Int](arr.size);
        for(i <- 0 to arr.size-1) minInd(i) = i;
        val m = readInt;
        for(i <- 1 to m){
            val nums = readLine.split(" ").map(x => x.toInt);
            val a = nums(0)-1;
            val b = nums(1)-1;
            if(minInd(a) != minInd(b)){
                val min = Math.min(minInd(a), minInd(b));
                val max = Math.max(minInd(a), minInd(b));
                if(arr(min).size > arr(max).size){
                    val move = arr(max);
                    for(f <- move) minInd(f) = min;
                    arr(min) ++= move;
                    arr(max) = Set();
                }else{
                    val move = arr(min);
                    for(f <- move) minInd(f) = max;
                    arr(max) ++= move;
                    arr(min) = Set();
                }
            }
        }
        println(cost(arr, 0, 0));
    }
    
    @tailrec    
    def cost(arr:Array[Set[Int]], ind:Int, c:Int):Int = {
        if(ind == arr.size) return c;
        return cost(arr, ind+1, c + Math.ceil(Math.sqrt(arr(ind).size)).toInt);
    }
}