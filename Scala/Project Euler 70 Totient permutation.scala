// https://www.hackerrank.com/contests/projecteuler/challenges/euler070

import scala.collection.mutable.HashMap;
object Solution {

    def main(args: Array[String]) {
        val n = readInt;
        val phi = phiArr(n);
        var minN = 2;
        var minR = 2.0;
        for(i <- 3 until n)
            if(i < minR * phi(i) && isPerm(i, phi(i))){
                minR = 1.0 * i / phi(i);
                minN = i;
            }
        println(minN);
    }
    
    def phiArr(n:Int):Array[Int] = {
        val phi = new Array[Int](n);
        for(i <- 2 until n) phi(i) = i;
        for(i <- 2 until n)if(phi(i) == i)for(j <- i until n by i){phi(j) /= i; phi(j) *= i-1}
        return phi;
    }
    
    def isPerm(aI:Int, bI:Int):Boolean = {
        if(aI.toString.size != bI.toString.size) return false;
        val a = getMap(aI);
        val b = getMap(bI);
        for(i <- a.keys){
            if(!b.contains(i) || a(i) != b(i)) return false;
        }
        return true;
    }
    
    def getMap(n:Int):HashMap[Int, Int] = {
        val m = new HashMap[Int, Int]();
        var t = n;
        while(t != 0){
            val d = t%10;
            if(!m.contains(d)) m += (d -> 1);
            else m(d) += 1;
            t /= 10;
        }
        return m;
    }
}