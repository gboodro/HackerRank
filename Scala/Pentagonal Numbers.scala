// https://www.hackerrank.com/challenges/pentagonal-numbers

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(pent(readLong));
    }
    
    def pent(n:Long):Long = {
        return n*(3*n-1)/2;
    }
}