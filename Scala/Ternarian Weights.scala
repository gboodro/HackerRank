// https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/ternarian-weights

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            var n = readInt;
            var p = 1;
            var left = List[Int]();
            var right = List[Int]();
            while(n > 0){
                if(n % 3 == 1){
                    right ::= p;
                }else if(n % 3 == 2){
                    left ::= p;
                    n += 1;
                }
                n /= 3;
                p *= 3;
            }   
            println("left pan: " + left.mkString(" "));
            println("right pan: " + right.mkString(" ")+"\n");
        }
    }
}