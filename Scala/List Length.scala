// https://www.hackerrank.com/challenges/fp-list-length

object Solution extends App {
def f(arr:List[Int]):Int = 
    if(!arr.isEmpty){
        1 + f(arr.tail);
}else{
    0;
}
  println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)))
}
