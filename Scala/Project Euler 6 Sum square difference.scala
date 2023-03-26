// https://www.hackerrank.com/contests/projecteuler/challenges/euler006

object Solution{
    def main(a:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(f(BigInt(readInt)));
    }
    
    def f(n:BigInt):BigInt = {
        return sqr(n*(n+1)/2) - n*(n+1)*(2*n+1)/6
    }
    
    def sqr(n:BigInt):BigInt = {n*n;}
}