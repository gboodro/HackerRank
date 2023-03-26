// https://www.hackerrank.com/challenges/easy-sum

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(f(readLine.split(" ").map(_.toInt)));
    }
    def f(a:Array[Int]):BigInt = {
        val n = BigInt(a(0));
        val m = BigInt(a(1));
        return tri(m-1)*(n/m) + tri(n%m);
    }
    def tri(n:BigInt):BigInt = {return n*(n+1)/2;}
}