// https://www.hackerrank.com/challenges/rotate-string

import scala.annotation.tailrec;
object Solution{
    def main(a:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(f(readLine.toCharArray));
    }
    def f(a:Array[Char]):String = {
        @tailrec
        def allRotate(s:String, cur:Int):String = {
            if(cur == a.size+1) return s.trim;
            else return allRotate(s + " " + rotate(a, cur), cur+1);
        }
        return allRotate("", 1);
    }
    def rotate(a:Array[Char], i:Int):String = {
        @tailrec
        def build(s:String, cur:Int):String = {
            if(cur == a.size) return s;
            else return build(s+a((i+cur)%a.size), cur+1);
        }
        return build("", 0);
    }
}