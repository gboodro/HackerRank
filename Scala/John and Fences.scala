// https://www.hackerrank.com/challenges/john-and-fences

object Solution{
    def main(args:Array[String]){
        readInt;
        println(maxA(readLine.split(" ").map(_.toInt).toList));
    }
    
    def maxA(a:List[Int]):Int = {
        if(a.isEmpty) return 0;
        val minI = splitBy(a);
        var max = minI._2*a.size;
        for(i <- minI._1)
            max = Math.max(max, maxA(i));
        return max;
    }
    
    def splitBy(L:List[Int]):Tuple2[List[List[Int]], Int] = {
        def aux(y:List[Int], m:Int, cur:List[Int], acc:List[List[Int]]):Tuple2[List[List[Int]], Int] = y match {
            case List() =>  if(cur.isEmpty) return (acc, m);
                            else return (cur::acc, m);
            case x::xs =>   if(x < m){
                                return aux(xs, x, List(), List(combWith((cur.reverse::acc).reverse, m)));
                            }else if(x == m){
                                if(cur.isEmpty) return aux(xs, m, List(), acc);
                                return aux(xs, m, List(), cur::acc);
                            }else{
                                return aux(xs, m, x::cur, acc);
                            }
        }
        return aux(L, 10001, List(), List());
    }
    def combWith(L:List[List[Int]], m:Int):List[Int] = {
        if(L.isEmpty) return List();
        else if(L.tail.isEmpty) return L.head;
        else return L.head:::(m::combWith(L.tail, m));
    }
}