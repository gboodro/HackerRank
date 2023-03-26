// https://www.hackerrank.com/contests/projecteuler/challenges/euler026

object Solution{
    def main(args:Array[String]){
        var max = 1;
        var maxN = 3;
        
        val maxA = new Array[Int](10001);
        maxA(3) = 3;
        for(i <- 4 until maxA.size){
            val c = f(i);
            if(c > max){max = c; maxN = i}
            maxA(i) = maxN;
        }
        val t = readInt;
        for(i <- 1 to t)
            println(maxA(readInt-1));
    }
    def f(n:Int):Int = {
        var m = n;
        while(m % 2 == 0) m /= 2;
        while(m % 5 == 0) m /= 5;
        if(m == 1) return 0;
        var r = 1L;
        var rep = 0;
        do{
            r *= 10;
            r %= m;
            rep+=1;
        }while(r != 1);
        return rep;
    }
}