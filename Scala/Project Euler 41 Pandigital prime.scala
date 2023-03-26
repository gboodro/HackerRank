// https://www.hackerrank.com/contests/projecteuler/challenges/euler041

object Solution{
    def main(args:Array[String]){
        val a = getMax(7654321);
        val t = readInt;
        for(i <- 1 to t){
            val n = readInt;
            if(n >= a.size) println(a(a.size-1));
            else println(a(n));
        }
    }
    def getMax(n:Int):Array[Int] = {
        val pans = getPrimePans(7);
        val a = new Array[Int](n+1);
        var m = -1;
        for(i <- 0 to n){
            if(pans(i)){
                a(i) = i;
                m = i;
            }else a(i) = m;
        }
        return a;
    }
    def getPrimePans(n:Int):Set[Int] = {
        var s = Set[Int]();
        for(i <- 1 to n){
            s ++= List.range(1, i+1).permutations.map(_.mkString("").toInt).filter(x => isPrime(x)).toSet;
        }
        return s;
    }
    def isPrime(n:Int):Boolean = {
        return BigInt(n).isProbablePrime(10);
    }
}
    