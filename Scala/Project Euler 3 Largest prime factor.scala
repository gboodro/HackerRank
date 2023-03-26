// https://www.hackerrank.com/contests/projecteuler/challenges/euler003

object Solution{
    def main(a:Array[String]){
        val t = readInt;
        for(i <- 1 to t){
            println(maxP(readLong));
        }
    }
    def maxP(n:Long):Long = {
        if(BigInt(n).isProbablePrime(10)) return n;
        else{
            if(n % 2 == 0) return maxP(n/2);
            else{
                val s = Math.sqrt(n).toInt;
                for(j <- 3 to s by 2) 
                    if(n % j == 0) 
                        return maxP(n/j);
                return 0;
            }
        }
    }
}