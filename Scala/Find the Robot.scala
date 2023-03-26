// https://www.hackerrank.com/contests/w17/challenges/find-the-robot

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val n = readInt();
            println((right(n) - left(n)) + " " + (up(n) - down(n)));
        }
    }
    
    def right(n:BigInt):BigInt = {
        val k = (n-1) / 4;
        return (2*k + 1) * (k+1);
    }
    
    def left(n:BigInt):BigInt = {
        val k = (n+1) / 4;
        return k * (2 * k + 1);
    }
    
    def up(n:BigInt):BigInt = {
        val k = (n+2) / 4;
        return 2*k*k;
    }
    
    def down(n:BigInt):BigInt = {
        val k = n / 4;
        return 2*k*(k+1);
    }
}