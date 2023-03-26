// https://www.hackerrank.com/contests/projecteuler/challenges/euler027

object Solution{
    val isP = isPrimes(4500000);
    def main(args:Array[String]){
        val n = readInt;
        var maxA = 0;
        var maxB = 0;
        var max = 0;
        
        for(b <- 2 to n){
            if(isP(b)){
                for(a <- Math.max(-n, -b) to n){
                    if(BigInt(a).gcd(BigInt(b)) == 1){
                        val c = cons(a, b, n);
                        if(c > max){
                            max = c;
                            maxA = a;
                            maxB = b;
                        }
                    }
                }
            }
        }
        
        println(maxA + " " + maxB);
    }
    def cons(a:Int, b:Int, n:Int):Int = {
        for(i <- 0 until n) if(!isPrime(i*i + a*i + b)) return i-1;
        return n;
    }
    def isPrimes(n:Int):Array[Boolean] = {
        val iP = Array.fill(n+1){true;}
        for(i <- 4 until iP.size by 2)iP(i) = false;
        for(i <- 3 until iP.size by 2)
            for(k <- i*2 until iP.size by i)
                iP(k) = false;
        return iP;
    }
    def isPrime(n:Int):Boolean = {
        if(n < 2) return false;
        return isP(n);
    }
}