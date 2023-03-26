// https://www.hackerrank.com/contests/projecteuler/challenges/euler020

object Solution{
    def main(args:Array[String]){
        val sumD = getSums(1000);
        val t = readInt;
        for(i <- 1 to t) println(sumD(readInt));
    }
    def getSums(n:Int):Array[Int] = {
        val a = new Array[Int](n+1);
        a(0) = 1;
        var num = 1;
        var fact = BigInt(1);
        for(i <- 1 until a.size){
            fact *= i;
            a(i) = sum(fact);
        }
        return a;
    }
    def sum(n:BigInt):Int = {
        var a = n;
        var s = 0;
        while(a > 0){
            s += (a%10).toInt;
            a/=10;
        }
        return s;
    }
}