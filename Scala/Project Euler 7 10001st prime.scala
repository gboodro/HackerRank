// https://www.hackerrank.com/contests/projecteuler/challenges/euler007

object Solution {
    def main(a:Array[String]){
        val p = new Array[BigInt](10000);
        var j = 0;
        var n = BigInt(2);
        while(j < p.size){
            while(!n.isProbablePrime(10)) n += 1;
            p(j) = n;
            n += 1;
            j += 1;
        }
        val t = readInt;
        for(i <- 1 to t) println(p(readInt-1));
    }
}