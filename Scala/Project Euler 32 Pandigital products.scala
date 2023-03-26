// https://www.hackerrank.com/contests/projecteuler/challenges/euler032

import scala.annotation.tailrec;
object Solution{
    
    def main(args:Array[String]){
        val ps = pans(readInt);
        println(sumGood(ps));
    }
    @tailrec
    def comb(s:Set[String], c:Int, acc:Set[String]):Set[String] = {
        if(s.isEmpty) return acc;
        else return comb(s.tail, c, acc + (s.head + c));
    }
    
    def pans(n:Int):Set[String] = {
        def aux(s:Set[Int], acc:Set[String]):Set[String] = {
            if(s.isEmpty) 
                return acc;
            else{
                var t = Set[String]();
                for(i <- s) 
                    t = t ++ aux(s-i, comb(acc, i, Set()));
                return t;
            }
        }
        return aux(List.range(1, n+1).toSet, Set(""));
    }
    
    def sumGood(s:Set[String]):Long = {
        var g = Set[Long]();
        for(i <- s)
            g ++= allGood(i);
        var sum = 0L;
        for(i <- g) sum += i;
        return sum;
    }
    
    def allGood(n:String):Set[Long] = {
        var good = Set[Long]();
        val len1 = n.size-1;
        val len2 = n.size;
        for(i <- 1 until len1)
            for(j <- i+1 until len2)
                if(n.substring(0, i).toLong * n.substring(i, j).toLong == n.substring(j).toLong)
                    good += n.substring(j).toLong;
        return good;
    }
}