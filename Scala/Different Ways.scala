// https://www.hackerrank.com/challenges/different-ways-fp

object Solution {
    
    var cMemo = Array.fill[Long](1001, 1001)(0) 
        
    def main(args: Array[String]) {
        val t = readLine.toInt;
        for( i <- 1 to t) 
            println(f(readLine.split(" ").toList.map(x=>x.toInt)));
    }
    
    def f(L:List[Int]):Long = L match {
        case x::xs => count(xs.head, x);
        case _ => 0;
    }
    
    def count(a:Int, b:Int):Long = {
        if(cMemo(a)(b) != 0) return cMemo(a)(b);
        else if(a == 0 || a == b){
            cMemo(a)(b) = 1;
            return 1;
        }else{
            cMemo(a)(b) = (count(a-1, b-1) + count(a, b-1)) % 100000007;
            return cMemo(a)(b);
        }
    }
}