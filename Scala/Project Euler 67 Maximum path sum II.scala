// https://www.hackerrank.com/contests/projecteuler/challenges/euler067

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val n = readInt;
            println(getMaxPath(n));
        }
    }
    
    def getMaxPath(n:Int):Int = {
        def aux(cur:List[Int], i:Int):Int = i match {
            case 0 => return cur.foldLeft(0)(Math.max);
            case _ => return aux(0::max(cur, readLine.split(" ").map(_.toInt).toList), i-1);
        }
        return aux(List(0, 0), n);
    }
    
    def max(a:List[Int], b:List[Int]):List[Int] = b match {
        case List() => return List(0);
        case x::xs => return Math.max(a.head, a.tail.head) + x::max(a.tail, xs);
    }
}