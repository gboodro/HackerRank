// https://www.hackerrank.com/contests/w13/challenges/taum-and-bday

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(b, w) = readLine.split(" ").map(_.toLong);
            val Array(x, y, z) = readLine.split(" ").map(_.toLong);
            println(b * Math.min(x, y+z) + w * Math.min(y, x+z));
        }
    }
                
    
}