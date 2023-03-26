// https://www.hackerrank.com/contests/projecteuler/challenges/euler014

object Solution{
    
    def main(args:Array[String]){
        var a = new Array[Int](5000001);
        for(i <- 1 until a.size)a(i)= chainLength(i);
        var b = new Array[Int](5000001);
        var max = 0L;
        var maxInd = 0;
        for(i <- 1 until a.size){
            if(max <= a(i)){
                max = a(i);
                maxInd = i;
            }
            b(i) = maxInd;
        }
        val t = readInt;
        for(i <- 1 to t)
            println(b(readLine.trim.toInt));
    }
    
    def chainLength(N:Long):Int = {
        var n = N;
        var length = 0;
        do{
            while(n % 2 == 0){
                n /= 2;
                length+=1;
            }
            if(n != 1){
                n = (3*n + 1)/2;
                length += 2;
            }
        }while(n != 1);
        return length;
    }
}