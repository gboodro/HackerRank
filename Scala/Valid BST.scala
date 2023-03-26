// https://www.hackerrank.com/challenges/valid-bst

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt;
        for(i <- 1 to t){
            readLine;
            println(vbst(readLine.split(" ").toList.map(x=>x.toInt)));
        }
    }
    
    def vbst(L:List[Int]):String = {
        if(valid(L)) return "YES";
        else return "NO";
    }
    
    def valid(L:List[Int]):Boolean = L match {
        case List() => true;
        case x::xs => 
            val sp = split(x, xs);
            return allGreater(x, sp(1)) && valid(sp(0)) && valid(sp(1));
    }
    
    def split(x:Int, L:List[Int]):Array[List[Int]] = {
        def aux(lst:List[Int], acc:List[Int]):Array[List[Int]] = lst match {
            case List() => Array(acc.reverse, List());
            case y::ys => if(y < x) 
                              return aux(ys, y::acc);
                          else
                              return Array(acc.reverse, y::ys);
        }
        return aux(L, List());
    }
    
    def allGreater(x:Int, L:List[Int]):Boolean = L match {
        case List() => true;
        case y::ys => y > x && allGreater(x, ys);
    }
}