// https://www.hackerrank.com/challenges/fp-hello-world-n-times

object Solution extends App {
def f(n:Int):Int = if(n > 0){
                       println("Hello World");
                       f(n-1);
                   }else
                        0;
  var n = readInt
  f(n)
}
