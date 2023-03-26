// https://www.hackerrank.com/contests/projecteuler/challenges/euler043

object Solution{
    def main(args:Array[String]){
        val p = List.range(0, readInt+1).permutations;
        var s = 0L;
        for(i <- p)
            if(good(i)) s += intOf(i);
        println(s);
    }
    def good(L:List[Int]):Boolean = {
        return intOf(L.slice(1, 4)) % 2 == 0 && intOf(L.slice(2, 5)) % 3 == 0 && intOf(L.slice(3, 6)) % 5 == 0 && intOf(L.slice(4, 7)) % 7 == 0 && intOf(L.slice(5, 8)) % 11 == 0 && intOf(L.slice(6, 9)) % 13 == 0 && intOf(L.slice(7, 10)) % 17 == 0;
    }
    def intOf(L:List[Int]):Long = {
        if(L.size < 3) return 0;
        return L.mkString("").toLong;
    }
}
    