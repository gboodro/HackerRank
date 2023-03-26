// https://www.hackerrank.com/challenges/hackerrank-tweets

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt;
        var total = 0;
        for( i <- 1 to t)
            if(readLine.toLowerCase.contains("hackerrank")) total += 1;
        println(total);
    }
}