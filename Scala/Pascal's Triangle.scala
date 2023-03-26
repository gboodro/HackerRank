// https://www.hackerrank.com/challenges/pascals-triangle

object Solution {

    def main(args: Array[String]) {
        f(readLine.toInt, List(1))
    }
    
    def f(n:Int, row:List[Int]):Unit = {
        if(n == 1) println(row.mkString(" "));
        else{
            println(row.mkString(" "));
            f(n-1, next(row));
        }
    }
    
    def next(r:List[Int]):List[Int] = {
        def loop(r:List[Int]):List[Int] = {
            if(r.size == 1) return r;
            else return (r.head + r.tail.head) :: loop(r.tail);
        }
        return 1::loop(r);
    }
}