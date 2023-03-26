// https://www.hackerrank.com/challenges/fp-filter-array

object Solution extends App {
def f(delim:Int,arr:List[Int]):List[Int] =
    if(arr.isEmpty){ List(); }
    else{val x = arr.head;
         if(x < delim){ x::f(delim, arr.tail); }
         else{f(delim, arr.tail);}}
  var lines = io.Source.stdin.getLines.toList
  println(f(lines(0).toInt,lines.map(_.trim).map(_.toInt)).map(_.toString).mkString("\n"))
}
