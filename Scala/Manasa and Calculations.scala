// https://www.hackerrank.com/contests/infinitum9/challenges/manasa-and-calculations

object Solution {

    def main(args: Array[String]) {
        val n = readInt;
        val m = BigInt(1000000007);
        var sum = BigInt(1);
        var aeqb = true;
        for(i <- 1 to n){
            val Array(p, a, b) = readLine.split(" ").map(_.toLong);
            if(a == b)
                sum *= BigInt(p).modPow(a, m);
            else{
                sum *= (BigInt(p).modPow(a, m) + BigInt(p).modPow(b, m)) % m;
                aeqb = false;
            }
            sum %= m;
        }
        if(aeqb) println(sum * 2 % m);
        else println(sum % m);
    }
}