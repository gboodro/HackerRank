// https://www.hackerrank.com/challenges/sherlock-and-counting

object Solution {
    def main(args:Array[String]) {
        val t = readLine.toInt;
        for(i <- 1 to t) println(f(readLine.split(" ").map(x => x.toLong)));
    }
    
    def f(arr:Array[Long]):Long = {
        val n = arr(0);
        val k = arr(1);
        if(n*n-4*n*k <= 0) 
            return n-1;
        val min = ((n - Math.sqrt(n*n-4*n*k))/2).toLong;
        val max = Math.ceil((n + Math.sqrt(n*n-4*n*k))/2).toLong;
        var s = 0L;
        if(min > 0){ 
            if(min >= n)
                return min;
            else
                s += min;
        }
        if(max < n){
            if(max <= 1)
                return n;
            else
                s+=n-max;
        }
        return s;
    }
}