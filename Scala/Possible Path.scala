// https://www.hackerrank.com/challenges/possible-path

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(f(readLine.split(" ").map(_.toLong)));
    }
    
    def f(arr:Array[Long]):String = {
        if(BigInt(arr(0)).gcd(BigInt(arr(1))) == BigInt(arr(2)).gcd(BigInt(arr(3)))) return "YES";
        else return "NO";
    }
}