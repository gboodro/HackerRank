// https://www.hackerrank.com/challenges/fp-list-replication

object Solution extends App {
 def aux(a:Int,b:Int):List[Int] = if(b == 0) List();
     else{
         a::aux(a, b-1);
     }
def f(num:Int,arr:List[Int]):List[Int] = if(arr.isEmpty){List();}
                                         else{
                                             aux(arr.head, num)++f(num, arr.tail);
                                         }

  def displayResult(arr:List[Int]) = println(f(arr(0).toInt,arr.drop(1)).map(_.toString).mkString("\n"))

  displayResult(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt))


}
