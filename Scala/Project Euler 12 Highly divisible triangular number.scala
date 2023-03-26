// https://www.hackerrank.com/contests/projecteuler/challenges/euler012

object Solution{
    val divCt = counts(40000000);
    def main(args:Array[String]){
        val t = readInt;
        //for(i <- 1 to t) println(i*(i+1)/ 2 + " " + divs(i));
        for(i <- 1 to t) println(f(readInt));
    }
    def f(n:Int):Long = {
        var i = 1;
        while(i < divCt.size && divs(i) <= n) i+= 1;
        return i*(i+1)/2;
    }
    def twoPow(n:Int):Int = {
        if(n % 2 == 0) return 1 + twoPow(n/2);
        return 0;
    }
    def divs(n:Int):Int = {
        var t = twoPow(n) + twoPow(n+1);
        return divCt(n)*divCt(n+1) / (t+1) * t;
    }
    def counts(n:Int):Array[Int] = {
        val a = Array.fill(n){1};
        var p = 2;
        while(p*p < a.size){
            var pow = p;
            var exp = 2;
            while(pow < a.size){
                for(i <- pow until a.size by pow) if(i % (p*pow) != 0) a(i) *= exp;
                pow *= p;
                exp += 1;
            }
            p = nextPrime(p);
        }
        return a;
    }
    def nextPrime(n:Int):Int = {
        if(BigInt(n+1).isProbablePrime(20)) return n+1;
        return nextPrime(n+1);
    }
}