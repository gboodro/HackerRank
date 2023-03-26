// https://www.hackerrank.com/challenges/huge-gcd-fp

object Solution {

    def main(args: Array[String]) {
        val p = getPrimes(10000);
        readLine;
        val aC = count(readLine.split(" ").toList.map(x => x.toInt), p);
        readLine;
        val bC = count(readLine.split(" ").toList.map(x => x.toInt), p);
        var g = 1L;
        for(prime <- p){
            val e = Math.min(aC(prime), bC(prime));
            if(e > 0){  
                g *= modPow(prime, e, 1000000007);
                g %= 1000000007; 
            }
        }
        println(g);
    }
    
    def count(nums:List[Int], ps:List[Int]):Array[Int] = {
        var arr = Array.fill[Int](10000)(0);
        for(p <- ps; n <- nums)
            arr(p) += numDivs(n, p); 
        return arr;
    } 
    
    def numDivs(n:Int, p:Int):Int = {
        if(n == 0 || n%p!=0) return 0;
        else return 1+numDivs(n/p, p);
    }
    
    def modPow(a:Long, p:Int, m:Long):Long = {
        if(p == 1) return a;
        else{
            var v = modPow(a, p/2, m);
            v *= v;
            v %= m;
            if(p % 2 == 1) v = (v*a) % m;
            return v;
        }
    }
    
    def getPrimes(n:Int):List[Int] = {
        def aux(nums:List[Int], ps:List[Int]):List[Int] = nums match {
            case List() => return ps.reverse;
            case x::xs => return aux(xs.filter(y => y % x != 0), x::ps);
        }
        return aux(List.range(2,n), List());
    }
}