// https://www.hackerrank.com/challenges/remove-duplicates

import scala.annotation.tailrec;
object Solution{
    def main(args:Array[String]){
        println(f(readLine.toCharArray.toList, Set(), ""));
    }
    @tailrec
    def f(L:List[Char], s:Set[Char], acc:String):String = L match {
        case List() => acc;
        case x::xs => if(s.contains(x)) return f(xs, s, acc) else return f(xs, s + x, acc + x);
    }
}