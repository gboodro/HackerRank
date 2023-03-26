// https://www.hackerrank.com/challenges/volleyball-match

object Solution {
    var mem = Array.ofDim[Long](25, 25);
    def main(args:Array[String]) {
        println(f(readLine.toInt, readLine.toInt));
    }
    
    def f(a:Int, b:Int):Long = {
        if(a < 24 && b == 25){
            return ways(b-1, a);
        }else if(b < 24 && a == 25){
            return ways(a-1, b);
        }else if(Math.abs(a-b) == 2){
            return (ways(24, 24) * pow(2, (Math.min(a, b)-24) % 500000003, 1000000007)) % 1000000007;
        }else{
            return 0;
        }
    }
    
    def ways(a:Int, b:Int):Long = {
        if(mem(a)(b) != 0) return mem(a)(b);
        if(a == 0 && b == 0) return 1;
        var s = 0L;
        if(a > 0) s += ways(a-1, b);
        s %= 1000000007;
        if(b > 0) s += ways(a, b-1);
        s %= 1000000007;
        mem(a)(b) = s;
        return s;
    }
    
    def pow(a:Long, p:Int, m:Int):Long = {
        if(p == 0) return 1;
        if(p == 1) return a%m;
        var v = pow(a, p/2, m);
        v*=v;
        v%=m;
        if(p%2==1) v = (a*v)%m;
        return v;
    }
}