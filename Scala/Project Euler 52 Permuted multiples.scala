// https://www.hackerrank.com/contests/projecteuler/challenges/euler052

object Solution {

    def main(args: Array[String]) {
        val Array(n, k) = readLine.split(" ").map(_.toInt);
        for(i <- 1 to n){
            val cur = getSet(i, k);
            if(cur._1) println(cur._2);
        }
    }
    def getSet(n:Int, k:Int):Tuple2[Boolean, String] = {
        val s = getMap(n);
        var res = n+"";
        for(i <- 2 to k)if(!equals(s, getMap(i*n))) return Tuple2(false, "");
            else res += " " + i*n;
        return Tuple2(true, res);
    }
    def getMap(n:Int):Array[Int] = {
        var i = n;
        val a = new Array[Int](10);
        while(i != 0){
            a(i%10)+=1;
            i/=10;
        }
        return a;
    }
    def equals(a:Array[Int], b:Array[Int]):Boolean = {
        for(i <- 0 until 10) if(a(i) != b(i)) 
            return false;
        return true;
    }
}