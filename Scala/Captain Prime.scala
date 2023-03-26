// https://www.hackerrank.com/contests/lambda-calculi-oct14/challenges/captain-prime

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t)
            println(loc(readLine));
    }
    
    def loc(s:String):String = {
        if(s.contains("0") || !BigInt(s).isProbablePrime(20)) return "DEAD";
        else{
            val R = isRight(s.dropRight(1));
            val L = isLeft(s.substring(1));
            if(L && R) 
                return "CENTRAL";
            else if(L) 
                return "LEFT";
            else if(R) 
                return "RIGHT";
            else 
                return "DEAD";
        }
    }
    def isLeft(s:String):Boolean = {
        if(s.isEmpty) return true;
        return BigInt(s).isProbablePrime(20) && isLeft(s.substring(1));
    }
    def isRight(s:String):Boolean = {
        if(s.isEmpty) return true;
        return BigInt(s).isProbablePrime(20) && isRight(s.dropRight(1));
    }
}