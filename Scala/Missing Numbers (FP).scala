// https://www.hackerrank.com/challenges/missing-numbers-fp

object Solution {

    def main(args: Array[String]) {
        println(f(readLine.toInt, readLine.split(" ").toList.map(x => x.toInt), readLine.toInt, readLine.split(" ").toList.map(x => x.toInt)));
    }
    
    def f(n:Int, A:List[Int], m:Int, B:List[Int]):String = {
        return subtract(count(B), count(A));
    }
    
    def subtract(B:Array[Int], A:Array[Int]):String = {
        def aux(B:Array[Int], A:Array[Int], curInd:Int, acc:List[Int]):String = {
            if(curInd == B.length)
                return stringOf(acc);
            else
                if(B(curInd) > A(curInd))
                    return aux(B, A, curInd+1, (curInd-10000)::acc);
                else
                    return aux(B, A, curInd+1, acc);
        }
        return aux(B, A, 0, List());
    }
    
    def stringOf(L:List[Int]):String = L match {
        case List() => "";
        case x::List() => x+"";
        case x::xs => stringOf(xs) + " " + x;
    }
    
    def count(L:List[Int]):Array[Int] = {
        def aux(L:List[Int], acc:Array[Int]):Array[Int] = L match {
            case List() => acc;
            case x::xs => acc(x+10000)+=1;
                          return aux(xs, acc);
        }
        return aux(L, Array.fill[Int](20001)(0));
    }
}