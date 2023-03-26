// https://www.hackerrank.com/challenges/manasa-and-stones

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(f(readInt, readInt, readInt));
    }
    
    def f(n:Int, a:Int, b:Int):String = {
        var arr = new Array[Boolean](n*Math.max(a, b) + 1);
        for(k <- 1 to n) arr(a*(n-k) + b*(k-1)) = true;
        var s = "";
        for(i <- 0 to arr.size-1) if(arr(i)) s += i + " ";
        return s.trim;
    }
}