// https://www.hackerrank.com/contests/projecteuler/challenges/euler046

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t)println(repWays(readInt));
    }
    def repWays(n:Int):Int = {
        var c = 0;
        var i = 1;
        while(n - 2*i*i > 1){
            if(BigInt(n-2*i*i).isProbablePrime(10))c+=1;
            i+=1;
        }
        return c;
    }
}