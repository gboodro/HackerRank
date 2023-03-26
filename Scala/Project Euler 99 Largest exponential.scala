// https://www.hackerrank.com/contests/projecteuler/challenges/euler099

object Solution {

    def main(args: Array[String]) {
        var arr = new Array[Tuple3[BigDecimal, Int, Int]](readInt);
        for(i <- 0 until arr.size){
            val Array(b, c) = readLine.split(" ").map(_.toInt);
            arr(i) = Tuple3(c*math.log(b), b, c);
        }
        val ans = arr.sortWith(_._1 < _._1)(readInt-1);
        print(ans._2 + " " + ans._3);
    }
}