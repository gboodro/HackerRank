// https://www.hackerrank.com/contests/projecteuler/challenges/euler002

object Solution{
    def main(a:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(sum(readLong));
    }
    
    def sum(n:Long):BigInt = {
        def sumEm(a:Long, b:Long, acc:BigInt):BigInt = {
            if(a > n) return acc;
            else return sumEm(b, a+b, acc + (a+1) % 2 * a);
        }
        return sumEm(1, 1, BigInt(0));
    }
}