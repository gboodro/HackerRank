// https://www.hackerrank.com/contests/101hack32/challenges/straight-flush

object Solution {

    def main(args: Array[String]) {
        val mapVal = Map("A" -> 1, "2" -> 2, "3" -> 3,"4" -> 4,"5" -> 5,"6" -> 6,"7" -> 7,"8" -> 8,"9" -> 9,"T" -> 10,"J" -> 11,"Q" -> 12,"K" -> 13);
        val c1 = readLine;
        val c2 = readLine;
        val c3 = readLine;
        val c4 = readLine;
        val c5 = readLine;
        var arr = Array(c1, c2, c3, c4, c5);
        var flush = true;
        for(i <- arr){
            if(i.charAt(i.size-1) != c1.charAt(c1.size-1)){
                flush = false;
            }
        }
        val iarr = arr.map(x => mapVal(x.substring(0, x.size - 1))).toList.sorted.toArray;
        var straight = true;
                             for(i <- 0 until iarr.size-1){
                                 if(iarr(i)+1 != iarr(i+1)){
                                     straight = false;
                                 }
                             }
        
        if(iarr(0) == 1 && iarr(1) == 10 && iarr(2) == 11 && iarr(3) == 12 && iarr(4) == 13){
            straight = true;
        }
                             
                             if(straight && flush)println("YES") else println("NO");
    }
}
