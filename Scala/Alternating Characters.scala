// https://www.hackerrank.com/contests/w10/challenges/alternating-characters

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt
        for(i <- 1 to t){
            val s = readLine;
            println(s.size - s.replaceAll("A+", "A").replaceAll("B+", "B").size);
        }
    }
}