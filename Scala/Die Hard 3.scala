// https://www.hackerrank.com/challenges/die-hard-3

object Solution {
    var a = 0;
    var b = 0;
    var c = 0;
    var s = Set[Tuple2[Int, Int]]();
    def main(arr:Array[String]){
        val t = readInt;
        for(i <- 1 to t){
            s = Set();
            var arr = readLine.split(" ").map(_.toInt);
            a = arr(0);
            b = arr(1);
            c = arr(2);
            if(f(Tuple2(0, 0))) println("YES");
            else println("NO");
        }
    }
    def f(t:Tuple2[Int, Int]):Boolean = {
        if(s.contains(t)) return false;
        s += t;
        if(t._1 == c || t._2 == c) return true;
        val pintob = Math.min(b-t._2, t._1);
        val pintoa = Math.min(a-t._1, t._2);
        return f(Tuple2(t._1-pintob, t._2+pintob)) || f(Tuple2(t._1+pintoa, t._2-pintoa)) || f(Tuple2(a, t._2)) || f(Tuple2(t._1, b)) || f(Tuple2(t._1, 0)) || f(Tuple2(0, t._2));
    }
}