// https://www.hackerrank.com/contests/projecteuler/challenges/euler054

object Solution {
    val valMap = Map('2' -> 2, '3' -> 3, '4' -> 4, '5' -> 5, '6' -> 6, 
                     '7' -> 7, '8' -> 8, '9' -> 9, 'T' -> 10, 'J' -> 11, 
                     'Q' -> 12, 'K' -> 13, 'A' -> 14);
    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            print("Player ");
            if(player1Wins(readLine.split(" ")))
                println("1");
            else
                println("2");
        }
    }
    def player1Wins(g:Array[String]):Boolean = {
        val p1 = handVal(g.slice(0, 5));
        val p2 = handVal(g.slice(5, 10));
        for(i <- 0 until p1.size) if(p1(i) != p2(i))
            return p1(i) > p2(i);
        return Math.random > 0.5;
    }
    def handVal(c:Array[String]):Array[Int] = {
        val v = c.map(x => valMap(x.charAt(0))).sorted;
        val isFlush = c.map(x => x.charAt(1)).toSet.size == 1;   
        // 7 - four of kind
            if(v(0) == v(1) && v(1) == v(2) && v(2) == v(3)) return Array(7, v(0), v(4));
            if(v(1) == v(2) && v(2) == v(3) && v(3) == v(4)) return Array(7, v(4), v(0));
        // 6 - full house
            if(v(0) == v(1) && v(1) == v(2) && v(3) == v(4)) return Array(6, v(0), v(4));
            if(v(0) == v(1) && v(2) == v(3) && v(3) == v(4)) return Array(6, v(4), v(0));
        // 3 - three of a kind
            if(v(0) == v(1) && v(1) == v(2)) return Array(3, v(0), v(4), v(3));
            if(v(1) == v(2) && v(2) == v(3)) return Array(3, v(1), v(4), v(0));
            if(v(2) == v(3) && v(3) == v(4)) return Array(3, v(2), v(1), v(0));
        // 2 - two pair
            if(v(0) == v(1) && v(2) == v(3)) return Array(2, v(3), v(1), v(4));
            if(v(0) == v(1) && v(3) == v(4)) return Array(2, v(4), v(1), v(2));
            if(v(1) == v(2) && v(3) == v(4)) return Array(2, v(4), v(2), v(0));
        // 1 - pair
            if(v(0) == v(1)) return Array(1, v(0), v(4), v(3), v(2));
            if(v(1) == v(2)) return Array(1, v(1), v(4), v(3), v(0));
            if(v(2) == v(3)) return Array(1, v(2), v(4), v(1), v(0));
            if(v(3) == v(4)) return Array(1, v(3), v(2), v(1), v(0));
        val isStraight = v(0) == v(3) - 3 && (v(3) + 1 == v(4) || (v(0) == 2 && v(4) == 14));
        // 9 - royal flush
            if(isFlush && isStraight)
                if(v(0) == 10) return Array(9);
                else return Array(8, v(3));
        // 5 - flush
            if(isFlush) return Array(5, v(4), v(3), v(2), v(1), v(0));
        // 4 - straight
            if(isStraight) return Array(4, v(3));
        // 0 -high card
            return Array(0, v(4), v(3), v(2), v(1), v(0));
    }
}