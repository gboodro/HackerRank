// https://www.hackerrank.com/contests/lambda-calculi-10/challenges/arctic-heist

object Solution {

    def main(args: Array[String]) {
        val y = readInt;
        var dice = Set[Tuple2[Double, Boolean]]();
        for(i <- 1 to y){
            val s = readLine.split(" ");
            val f = s(0).toDouble;
            dice += Tuple2((f-1)/f, s(1) == "Yes");
        }
        val bN = bestN(dice);
        if(Math.abs(prob(dice, bN+1) - prob(dice, bN)) > 0.000005 && y != 2)
            println(bN+1);
        else println(bN);
    }
    
    def bestN(s:Set[Tuple2[Double, Boolean]]):Int = {
        var bN = 0;
        var bP = 0.0;
        for(i <- 2 until 100000000 by 1000){
            val p = prob(s, i);
            if(p > bP){
                bP = p;
                bN = i;
            }
        }
        val n1 = traverse(s, bN, bP, 1);
        val n2 = traverse(s, bN, bP,-1);
        if(n1._2 > bP){
            bP = n1._2;
            bN = n1._1;
        }
        if(n2._2 > bP){
            bP = n2._2;
            bN = n2._1;
        }
        return bN;
    }
    
    def traverse(s:Set[Tuple2[Double, Boolean]], curN:Int, curP:Double, step:Int):Tuple2[Int, Double] = {
        var bN = curN;
        var bP = curP;
        for(i <- 1 to 2000){
            val n = curN + step*i;
            if(n < 2 || n > 99999999) return Tuple2(bN, bP);
            val p = prob(s, n);
            if(p > bP){
                bP = p;
                bN = n;
            }
        }
        return Tuple2(bN, bP);
    }
    
    def prob(s:Set[Tuple2[Double, Boolean]], n:Int):Double = {
        var pr = 1.0;
        for(i <- s){
            val p = Math.pow(i._1, n);
            if(i._2) pr *= 1-p;
            else pr *= p;
        }
        return pr;
    }
}