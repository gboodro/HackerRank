// https://www.hackerrank.com/challenges/fibonacci-fp

import collection.mutable.HashMap
object Solution {
    
    var fib = HashMap[Int,Long](0 -> 0l, 1 -> 1l, 2 -> 1l);
    def main(args: Array[String]) {
        
        f(readLine.toInt)
    }
    
    def f(i:Int):Unit = {
        val t = readLine.toInt
        println(g(t))
        if(i > 1) f(i-1)
    }
    
    def g(n:Int):Long = {
        if(fib.contains(n)) 
            return fib.getOrElse(n, 0);
        else{
            val v = (((g(n/2+1)*g(n-n/2)) % 100000007) + ((g(n/2)*g(n-n/2-1)) % 100000007)) % 100000007; 
            fib.put(n, v);
            return v;
        }
    }
}