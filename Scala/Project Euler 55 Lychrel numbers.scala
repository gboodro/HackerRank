// https://www.hackerrank.com/contests/projecteuler/challenges/euler055

import scala.collection.mutable.HashMap;
object Solution {

    def main(args: Array[String]) {
        var palCt = new HashMap[BigInt, Int]();
        val n = readInt;
        for(i <- 1 to n){
            var iter = 0;
            var num = BigInt(i);
            while(iter < 60 && !isPal(num.toString)){
                num = next(num);
                iter += 1;
            }
            if(iter < 60)
                if(palCt.contains(num))
                    palCt(num) += 1;
                else palCt += (num -> 1);
        }
        var max = 0;
        var v = BigInt(0);
        for(i <- palCt.keys) if(palCt(i) > max){
            max = palCt(i);
            v = i;
        }
        println(v + " " + max);
    }
    def isPal(s:String):Boolean = {
        val len = s.size/2;
        for(i <- 0 until len)
            if(s.charAt(i) != s.charAt(s.size-1-i))
            return false;
        return true;
    }
    def next(i:BigInt):BigInt = {
        var rev = BigInt(0);
        var c = i;
        while(c > 0){
            rev = rev*10 + c%10;
            c/=10;
        }
        return i + rev;
    }
}