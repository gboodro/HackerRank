// https://www.hackerrank.com/challenges/manasa-and-factorials

object Solution {
    def main(args:Array[String]){
        val t = readLine.toInt;
        for(i <- 1 to t) println(f(readLine.toLong));
    }
    
    def f(a:Long):Long = {
        return g(a, 5*a, a);
    }
    
    def g(a:Long, b:Long, n:Long):Long = {
        if(a + 1 == b) return b;
        val h = H((a+b)/2, n);
        if(h >= n) return g(a, (a+b)/2, n);
        else return g((a+b)/2, b, n);
    }
    
    def H(a:Long, n:Long):Long = {
        if(a == 0) return 0;
        else return a/5 + H(a/5, n);
    }
}