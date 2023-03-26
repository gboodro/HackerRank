// https://www.hackerrank.com/contests/infinitum-sep14/challenges/mehta-and-his-laziness

object Solution {

    def main(args: Array[String]) {
        val pdiv = getDivs(1000000);
        val epdiv = getEDivs(1000000);
        val t = readInt;
        for(i <- 1 to t){
            val n = readInt;
            val p = epdiv(n);
            val q = pdiv(n);
            if(p == 0) println(0);
            else{
                val g = BigInt(p).gcd(BigInt(q));
                println(p/g + "/" + q/g);
            }
        }
    }
    def getDivs(n:Int):Array[Int] = {
        val a = new Array[Int](n+1);
        for(i <- 1 to n/2)
            for(j <- i*2 to n by i)
                a(j) += 1;
        return a;
    }
    def getEDivs(n:Int):Array[Int] = {
        val a = new Array[Int](n+1);
        for(i <- 2L to n/2 by 2)
            for(j <- i*i*2 to n by i*i)
                a(j.toInt) += 1;
        return a;
    }
}