// https://www.hackerrank.com/contests/infinitum11/challenges/check-gcd

object Solution {
    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(_, k) = readLine.split(" ").map(_.toInt);
            var L = readLine.split(" ").map(_.toInt).toList.filter(_ % k == 0);
            if(L.isEmpty) println("NO");
            else println(check(L.tail, k, L.head));
        }
    }
    def check(s:List[Int], k:Int, L:Int):String = {
        var g = L;
        for(p <- s){
            g = gcd(g, p);
            if(g == k) return "YES";
        }
        if(g == k) return "YES";
        return "NO";
    }
    
    def gcd(a:Int, b:Int):Int = { return if(b == 0) a; else gcd(b, a%b); }
}