// https://www.hackerrank.com/contests/w21/challenges/luck-balance

object Solution {

    def main(args: Array[String]) {
        val Array(n, k) = readLine.split(" ").map(_.toInt);
        val important = new Array[Int](n);
        var luck = 0;
        for(i <- 0 until n){
            val contest = readLine.split(" ").map(_.toInt);
            if(contest(1) == 1){
                important(i) = contest(0);
            }else{
                luck += contest(0);
            }
        }
        val L = important.toList.filter(_ != 0).sortWith(_ > _);
        println(luck + L.take(k).sum - L.drop(k).sum);
    }
}