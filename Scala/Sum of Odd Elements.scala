// https://www.hackerrank.com/challenges/fp-sum-of-odd-elements

object Solution extends App {
 def f(arr:List[Int]):Int = 
     if(!arr.isEmpty){
            val x = arr.head;
         if(x % 2 != 0){
            x+f(arr.tail);
         }else
            f(arr.tail);
    }else
        0;
  println(f(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt)))
}
