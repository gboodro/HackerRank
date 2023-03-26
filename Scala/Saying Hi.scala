// https://www.hackerrank.com/challenges/saying-hi

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt;
        for( i <- 1 to t) f(readLine);
    }
    
    def f(a:String):Unit = {
        if(a.startsWith("hi ") || a.startsWith("Hi ") || a.startsWith("hI ") || a.startsWith("HI ")) if(a.charAt(3) == 'd' || a.charAt(3) == 'D') return else println(a);
    }
}