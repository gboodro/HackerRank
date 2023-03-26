// https://www.hackerrank.com/contests/projecteuler/challenges/euler024

object Solution{
    val fact = new Array[Long](20);
    def main(args:Array[String]){
        fact(0) = 1L;
        for(i <- 1 until fact.size) fact(i) = fact(i-1) * i;
        val t = readInt;
        for(i <- 1 to t){
            println(f("abcdefghijklm", readLong));
        }
    }
    def f(A:String, N:Long):String = {
        var a = A;
        var n = N-1;
        var s = "";
        while(!a.isEmpty){
            val i = (n/fact(a.size-1)).toInt;
            n -= i*fact(a.size-1);
            s += a.charAt(i);
            a = a.substring(0, i) + (if(i < a.size) a.substring(i+1) else "");
        }
        return s;
    }
}