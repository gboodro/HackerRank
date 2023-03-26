// https://www.hackerrank.com/challenges/dance-class

object Solution {
    
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) 
            if(N(readLong)) 
                println("even");
            else 
                println("odd");
    }
    
    def N(n:Long):Boolean = {
        var a = BigInt(Math.sqrt(n).toLong-4);
        while(a*a <= n) a+=1; 
        return a % 2 == 1;
    }
}