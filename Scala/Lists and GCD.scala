// https://www.hackerrank.com/contests/lambda-calculi-9/challenges/lists-and-gcd

object Solution {

    def main(args: Array[String]) {
        println(f(readInt-1, getTups(readLine.split(" ").map(_.toInt).toList)));
    }
    type LTup = List[Tuple2[Int, Int]];
    def f(q:Int, g:LTup):String = {
        if(q == 0) return g.sortWith(_._1 < _._1).map(x => x._1 + " " + x._2).mkString(" ");
        return f(q-1, gcd(g, getMap(readLine.split(" ").toList.map(_.toInt))));
    }
    
    def getTups(L:List[Int]):LTup = L match {
        case x::(y::ys) => (x, y)::getTups(ys);
        case _ => List();
    }
    
    def getMap(L:List[Int]):Map[Int, Int] = L match {
        case x::(y::ys) => getMap(ys) + (x -> y);
        case _ => Map();
    }
    
    def gcd(a:LTup, b:Map[Int, Int]):LTup = a match {
        case x::xs =>   if(b.contains(x._1)) return (x._1, Math.min(x._2, b(x._1)))::gcd(xs, b);
                        else return gcd(xs, b);
        case _ => List();
    }
}