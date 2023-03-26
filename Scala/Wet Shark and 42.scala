// https://www.hackerrank.com/contests/infinitum9/challenges/wet-shark-and-42

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            println(f(readLong) % 1000000007);
        }
    }
    
    def f(s:BigInt):BigInt = {
        var n = 21*s/10;
        n += n%2;
        while(count(n) < s) n += 2;
        while(count(n-2) >= s) n -= 2; 
        return n;
    }
    
    def count(n:BigInt):BigInt = {
        return n/2 - n/42;
    }
}