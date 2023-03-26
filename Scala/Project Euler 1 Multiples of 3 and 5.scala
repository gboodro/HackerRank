// https://www.hackerrank.com/contests/projecteuler/challenges/euler001

object Solution{
    def main(a:Array[String]){
        val t = readInt;
        for(i <- 1 to t){
            println(f(readInt-1));
        }
    }
    
    def f(n:Int):Long = {
        return tri(n/3)*3 + tri(n/5)*5 - tri(n/15)*15;
    }
    
    def tri(n:Long):Long = {
        return n*(n+1)/2;
    }
}