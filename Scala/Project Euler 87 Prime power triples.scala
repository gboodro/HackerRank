// https://www.hackerrank.com/contests/projecteuler/challenges/euler087

object Solution {

    def main(args: Array[String]) {
        val primes = List.range(2, 3162).map(x => BigInt(x)).filter(_.isProbablePrime(10)).toArray;
        val isPoss = new Array[Int](10000001);
        var i = 0;
        while(i < primes.size && primes(i) * primes(i) * primes(i) * primes(i) < isPoss.size){
            val pi = primes(i) * primes(i) * primes(i) * primes(i);
            var j = 0;
            while(j < primes.size && pi + primes(j) * primes(j) * primes(j) < isPoss.size){
                val pj = primes(j) * primes(j) * primes(j) + pi;
                var k = 0;
                while(k < primes.size && pj + primes(k) * primes(k) < isPoss.size){
                    val pk = pj + primes(k) * primes(k);
                    if(pk < isPoss.size) isPoss(pk.toInt) = 1;
                    k += 1;
                }
                j += 1;
            }
            i+=1;
        }
        for(i <- 1 until isPoss.size) isPoss(i) += isPoss(i-1);
        val t = readInt;
        for(i <- 1 to t){
            println(isPoss(readInt));
        }
    }
}