// https://www.hackerrank.com/challenges/number-of-binary-search-tree

object Solution {
    var allMemo = Array.fill[Long](1001)(0)
    def main(args: Array[String]) {
        val t = readLine.toInt;
        for( i <- 1 to t) println(all(readLine.toInt));
    }
    
    def all(n:Int):Long = n match {
        case 0 => 1;
        case _ => 
            if(allMemo(n) != 0) return allMemo(n);
            else {
                def aux(cur:Int, acc:Long):Long = {
                          if(cur > n)
                              return acc;
                          else
                              return aux(cur+1, (acc+(all(cur-1)*all(n-cur))%100000007) % 100000007);
                }
                allMemo(n) = aux(1, 0); 
                return allMemo(n);
        }
    }
}