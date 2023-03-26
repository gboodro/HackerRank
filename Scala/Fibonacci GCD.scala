// https://www.hackerrank.com/contests/infinitum9/challenges/fibonacci-gcd

import scala.collection.mutable.HashMap;
object Solution {
    
    val fibBack = new HashMap[Long, BigInt]();
    val m = BigInt(1000000007);
    
    def main(args: Array[String]) {
        
        fibBack += (0L -> BigInt(0));
        fibBack += (1L -> BigInt(1));
        fibBack += (2L -> BigInt(1));
        
        var n = readInt;
        var g = BigInt(readLong);
        while(n > 1 && g != 1){
            g = g.gcd(BigInt(readLong));
            n -= 1;
        }
        println(fib(g));
    }
 
    def fib(n:BigInt):BigInt = {
        return fBack(n.toLong);
    }
    
    def fBack(n:Long):BigInt = {
        if(!fibBack.contains(n)){
            val k = n/2;
            val v1 = fBack(k+1) * fBack(n-k) % m;
            val v2 = fBack(k) * fBack(n-k-1) % m;
            fibBack += (n -> (v1 + v2) % m);
        }
        return fibBack(n);
    }
}