// https://www.hackerrank.com/challenges/find-point

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(px, py, qx, qy) = readLine.split(" ").map(_.toInt);
            println((qx - (px-qx)) + " " + (qy - (py-qy)));
        }
    }
}