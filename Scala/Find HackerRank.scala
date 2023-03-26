// https://www.hackerrank.com/challenges/find-hackerrank

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt;
        for( i <- 1 to t) println(f(readLine))
    }
    
    def f(t:String):Int = {
        val tar = "hackerrank";
        if(t.startsWith(tar)){
            if(t.endsWith(tar)) 0;
            else 1;
        }else if(t.endsWith(tar)) 2;
        else -1;
    }
}