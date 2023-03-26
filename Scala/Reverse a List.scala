// https://www.hackerrank.com/challenges/fp-reverse-a-list

object Solution extends App {
 def f(arr:List[Int]):List[Int] = 
     if(!arr.isEmpty){
         f(arr.tail)++List(arr.head);
 }else{
     List();
 }
  println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)).mkString("\n"))
}
