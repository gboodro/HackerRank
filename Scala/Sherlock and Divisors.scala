// https://www.hackerrank.com/challenges/sherlock-and-divisors

object Solution{
    
    val p = getPrimes(Math.sqrt(1000000000).toInt);
    
    def main(a:Array[String]){
        val t = readInt;
        for(i <- 1 to t) 
            println(f(readInt));
    }
    
    def split(a:Int, b:Int, t:Int):Tuple2[Int, Int] = {
        if(b % t == 0) return split(a+1, b/t, t);
        else return (a, b);
    }
    
    def f(n:Int):Int = {
        val spl = split(0, n, 2);
        return spl._1 * divs(spl._2);
    }
    
    def getPrimes(n:Int):List[Int] = {
        def getP(a:Int, L:List[Int]):List[Int] = {
            def isP():Boolean = {
                for(i <- L) if(a % i == 0) return false;
                return true;
            }
            if(a > n) return L.reverse;
            else if(isP()) return getP(a+1, a::L);
            else return getP(a+1, L);
        }
        return getP(2, List());
    }
    
    def divs(n:Int):Int = {
        if(BigInt(n).isProbablePrime(10)) return 2;
        for(pr <- p){
            if(pr*pr <= n){
                if(n % pr == 0){
                    val spl = split(0, n, pr);
                    return (spl._1+1) * divs(spl._2);
                }
            }else{
                if(n == 1) return 1;
                else return 2;
            }
        }
        return 1/0;
    }
}