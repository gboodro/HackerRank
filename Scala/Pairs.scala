// https://www.hackerrank.com/challenges/pairs

object Solution {

    def main(args: Array[String]) {
        val Array(n, k) = readLine.split(" ").map(_.toInt);
        val s = readLine.split(" ").map(_.toInt).toSet;
        var c = 0;
        for(i <- s) if(s.contains(i+k)) c += 1;
        println(c);
    }
    
}