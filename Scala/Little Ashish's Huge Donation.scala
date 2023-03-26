// https://www.hackerrank.com/contests/infinitum-sep14/challenges/little-chammys-huge-donation

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t)println(f(readLong));
    }
    def f(n:Long):Long = {
        var i = Math.cbrt(n*3).toLong;
        while(i*(i+1)*(2*i+1) <= 6*n)i+=1;
        return i-1;
    }
}