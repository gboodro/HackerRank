// https://www.hackerrank.com/contests/projecteuler/challenges/euler013

object Solution{
    
    def main(args:Array[String]){
        println(sum(readInt));
    }
    
    def sum(n:Int):String = {
        var s = BigInt(0);
        for(i <- 1 to n) s += BigInt(readLine);
        return s.toString.substring(0, 10);
    }
}