// https://www.hackerrank.com/challenges/fp-update-list

object Solution extends App {
def f(arr:List[Int]):List[Int] = if(!arr.isEmpty){
                                     val x = arr.head;
    if(x > 0){x::f(arr.tail)}
    else{(-x)::f(arr.tail)}
}else{
    List();
}
                                     
  println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)).map(_.toString).mkString("\n"))
}
