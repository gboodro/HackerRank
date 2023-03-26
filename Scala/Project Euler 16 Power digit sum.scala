// https://www.hackerrank.com/contests/projecteuler/challenges/euler016

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(f(Array(2, readInt)));
    }
    def f(a:Array[Int]):BigInt = {
        return sumD(BigInt(a(0)).pow(a(1)));
    }
    def sumD(n:BigInt):BigInt = {
        var t = n;
        var s = BigInt(0);
        while(t > 0){
            s += t%10;
            t /= 10;
        }
        return s;
    }
}