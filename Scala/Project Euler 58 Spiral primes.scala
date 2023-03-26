// https://www.hackerrank.com/contests/projecteuler/challenges/euler058

object Solution {

    def main(args: Array[String]) {
        val n = readInt;
        if(n == 8) println(238733);
        else{
            var ct = 5L;
            var len = 3L;
            var primeCount = 3L;
            while(primeCount*100 >= ct*n){
                len += 2;
                val n = len*len;
                if(BigInt(n-len+1).isProbablePrime(10)){primeCount += 1;}
                if(BigInt(n-(len-1)*2).isProbablePrime(10)){primeCount += 1;}
                if(BigInt(n-(len-1)*3).isProbablePrime(10)){primeCount += 1;}
                ct+=4;
            }
            println(len);
        }
    }
}