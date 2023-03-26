// https://www.hackerrank.com/contests/lambda-calculi-10/challenges/composition-of-2-primes

object Solution {

    def main(args: Array[String]) {
        val p = sieve(1000000);
        val max = 100000000000000000L
        val a = Array.fill(1000001){max};
        var i1 = 0;
        while(i1 < p.size && p(i1) * 2 < a.size){
            val pL = p(i1).toLong;
            val pI = p(i1);
            var j = i1+1;
            while(j < p.size && pI + p(j) < a.size){
                if(pL*p(j) < a(pI + p(j))) a(pI + p(j)) = pL * p(j);
                j += 1;
            }
            i1+=1;
        }
        val t = readInt;
        for(i <- 1 to t){
            var m = BigInt(1);
            var n = 0;
            val Array(k, b) = readLine.split(" ").map(_.toInt);
            for(w <- k to b){
                if(a(w) != max){
                    n += 1;
                    m *= a(w) % 1000000007L;
                    m %= 1000000007L;
                }
            }
            println(n + " " + (m%1000000007));
        }
    }
    
    def sieve(n:Int):Array[Int] = {
        var L = Set(2);
        val isP = Array.fill(n+1){true};
        for(i <- 3 to n by 2 if isP(i)){
            L += i;
            for(j <- i to n by i) isP(j) = false;
        }
        return L.toArray.sorted;
    }
}