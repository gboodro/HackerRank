// https://www.hackerrank.com/challenges/sherlock-and-gcd

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t){
            readLine;
            println(f(readLine.split(" ").map(_.toInt)));
        }
    }
    def f(arr:Array[Int]):String = {
        var g = arr(0);
        for(a <- arr){
            g = gcd(a, g);
            if(g == 1) return "YES";
        }
        return "NO";
    }
    def gcd(a:Int, b:Int):Int = {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}