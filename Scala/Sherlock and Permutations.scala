// https://www.hackerrank.com/challenges/sherlock-and-permutations

object Solution{
    val fact = Array.fill(2001){BigInt(1)}
    val m = 1000000007L;
    def main(args:Array[String]){
        for(i <- 1 to fact.size-1) 
            fact(i) = (fact(i-1)*i); 
        val t = readInt; 
        for(i <- 1 to t) 
            println(f(readLine.split(" ").map(x => x.toInt)))
    }
    def f(n:Array[Int]):BigInt = {
        return (fact(n(0)+n(1)-1)/fact(n(0))/fact(n(1)-1))%m
    }
}