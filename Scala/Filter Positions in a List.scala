// https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list

object Solution extends App {
def f(arr:List[Int]):List[Int] = if(arr.isEmpty){List();}
                                 else{
                                     val x = arr.tail;
                                     if(!x.isEmpty){
                                         x.head::f(x.tail);
                                     }else{
                                         List();
                                     }
                                 }

  println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)).mkString("\n"))
}

