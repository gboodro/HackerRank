// https://www.hackerrank.com/contests/indeed-prime-codesprint/challenges/divyam-and-sorted-list

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            readInt;
            val a = readLine.split(" ").map(_.toLong).toList;
            val b = readLine.split(" ").map(_.toLong).toList;
            println(related(a, b));
        }
    }
    def related(a:List[Long], b:List[Long]):String = {
        def aux(ac:List[Long], bc:List[Long], cur:Long):String = ac match {
            case List() => return "YES";
            case x::xs => {
                val m = Math.min(x, bc.head);
                val M = Math.max(x, bc.head);
                if(m >= cur)
                    return aux(xs, bc.tail, m);
                else if(M >= cur)
                    return aux(xs, bc.tail, M);
                return "NO";
            }
        }
        return aux(a.tail, b.tail, Math.min(a.head, b.head));
    }
}