// https://www.hackerrank.com/contests/infinitum9/challenges/eulers-criterion

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(a, m) = readLine.split(" ").map(_.toInt);
            if(m == 2 || a < 2 || euler(a, m) == 1) println("YES");
            else println("NO");
        }
    }
    
    def euler(a:Int, m:Int):Int = {
        if(BigInt(a).modPow(m/2, m) == 1) return 1;
        else return -1;
    }
    
    
}