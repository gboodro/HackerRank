// https://www.hackerrank.com/contests/projecteuler/challenges/euler053

object Solution {

    def main(args: Array[String]) {
        val Array(m, k) = readLine.split(" ").map(_.toLong);
        val n = m.toInt;
        val ncr = new Array[Array[BigInt]](n+1);
        for(i <- 0 until ncr.length){
            ncr(i) = new Array[BigInt](i+1);
        }
        for(i <- 0 until n){
            ncr(i)(0) = 1;
            ncr(i)(i) = 1;
        }
        var ct = 0;
        for(i <- 2 to n){
            for(j <- 1 until i){
                ncr(i)(j) = ncr(i-1)(j-1) + ncr(i-1)(j);
                if(ncr(i)(j) > k) ct+=1;
            }
        }
        println(ct);
        //println(ncr.map(_.toList.mkString(" ")).mkString("\n"));
    }
}