// https://www.hackerrank.com/contests/infinitum14/challenges/most-distant

import java.awt.geom.Point2D;
object Solution {

    def main(args: Array[String]) {
        val n = readInt;
        var minX = 0;
        var maxX = 0;
        var minY = 0;
        var maxY = 0;
        for(i <- 1 to n){
            val Array(x, y) = readLine.split(" ").map(_.toInt);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
        println(List(maxX-minX, maxY-minY, Point2D.distance(Math.max(maxX, -minX), 0, 0, Math.max(maxY, -minY))).max);
    }
}