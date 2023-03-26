// https://www.hackerrank.com/challenges/counter-game

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t)println(count(BigInt(readLine)));
    }
    def count(n:BigInt):String = {
        var m = n;
        var c = 0;
        while(m != 1){
            c += 1;
            var p = BigInt(1);
            while(2*p < m) p *= 2;
            m -= p;
        }
        if(c % 2 == 0) return "Richard";
        return "Louise";
    }
}