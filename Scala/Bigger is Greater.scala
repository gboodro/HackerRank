// https://www.hackerrank.com/challenges/bigger-is-greater

object Solution {
    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t)println(lG(readLine.toCharArray.toList.reverse));
    }
    def lG(L:List[Char]):String = {
        def aux(a:List[Char], b:List[Char]):String = a match {
            case List() => return "no answer";
            case x::xs => if(x < b.head) return xs.reverse.mkString("") + order(x, b.reverse).mkString("");
                          else return aux(xs, x::b);
        }
        return aux(L.tail, List(L.head));
    }
    def order(a:Char, L:List[Char]):List[Char] = {
        def aux(b:List[Char], acc:List[Char]):List[Char] = b match {
            case List() => return a::acc;
            case x::xs => if(x > a) return x::((a::acc).reverse ++ xs);
                          else return aux(xs, x::acc);
        }
        return aux(L, List());
    }
}