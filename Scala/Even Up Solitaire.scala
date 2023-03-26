// https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/even-up-solitaire

object Solution {

    def main(args: Array[String]) {
        readLine;
        val L = getConPar(readLine.split(" ").map(_.toInt).toList);
        println(reduce(L));
    }
    
    def getConPar(L:List[Int]):List[Int] = {
        def aux(ls:List[Int], curCt:Int, curPar:Int):List[Int] = ls match {
            case List() => List(curCt);
            case x::xs => {
                if(x % 2 == curPar) 
                    return aux(xs, curCt+1, curPar);
                else
                    return curCt::aux(xs, 1, x%2);
            }
        }
        return aux(L.tail, 1, L.head%2);
    }
    
    def reduce(L:List[Int]):Int = {
        var ct = L.sum;
        for(i <- L) ct -= i/2*2;
        var s = L.map(_ % 2).mkString("");
        do{
            while(s.contains("00")) s = s.replaceFirst("00", ""); 
            while(s.contains("101")){
                ct -= 2;
                s = s.replaceFirst("101", "0");
            }
        }while(s.contains("00"));
        return ct;
    }
}