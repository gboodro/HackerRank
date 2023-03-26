// https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/goldbachs-conjecture

object Solution {
    val p = List.range(2, 32000).filter(x => BigInt(x).isProbablePrime(20));
    val ps = new Array[Boolean](32001);
    def main(args: Array[String]) {
        val t = readInt;
        for(prime <- p) ps(prime) = true;
        for(i <- 1 to t){
            val n = readInt;
            val res = getResSet(n);
            println(n +" has " + res.size + " representation(s)\n" + res.mkString("\n") + "\n");
        }
    }
    def getResSet(n:Int):List[String] = {
        var res = List[String]();
        val m = n/2;
        for(i <- p){
            if(i > m) return res.reverse;
            if(ps(n-i)){
                res ::= i+"+"+(n-i);
            }
        }
        return res;
    }
}