// https://www.hackerrank.com/challenges/fp-array-of-n-elements

object Solution extends App {
    def f(num:Int):List[Int] =  if (num > 0){
                                    1::(f(num-1))
                                }else{
                                    List()
                                }
  println(f(readInt).length)
}
