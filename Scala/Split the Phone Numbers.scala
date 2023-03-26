// https://www.hackerrank.com/challenges/split-number

object Solution {

    def main(args: Array[String]) {
        val n = readLine.toInt;
        for( i <- 1 to n) println(f(readLine));
    }
    
    def f(p:String):String = {
        if(p.contains("-")){
            val g = p.split("-");
            return "CountryCode=" + g(0) + ",LocalAreaCode=" + g(1) + ",Number=" + g(2);
        }else{
            val g = p.split(" ");
            return "CountryCode=" + g(0) + ",LocalAreaCode=" + g(1) + ",Number=" + g(2);
        }
    }
    
}