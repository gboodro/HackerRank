// https://www.hackerrank.com/contests/infinitum11/challenges/prime-factorization-2

object Solution {

    def main(args: Array[String]) {
        val p = sieve(2000000);
        val arr = new Array[Long](2000001);
        for(i <- p)for(j <- i until arr.size by i)arr(j.toInt) += count(j, i);
        var s = 0L;
        val t = readInt;
        for(i <- 2 until arr.size) if(arr(i) == 0) arr(i) = i;
        for(i <- 1 to t) s += arr(readInt);
        println(s);
    }
    def count(n:Long, p:Long):Long = { return if (n % p == 0 && n != 1) p + count(n/p, p) else 0; }
    def sieve(n:Int):Set[Int] = {
        var L = Set(2);
        val isP = Array.fill(n+1){true};
        for(i <- 3 to n by 2 if isP(i)){
            L += i;
            for(j <- i to n by i) isP(j) = false;
        }
        return L;
    }
}