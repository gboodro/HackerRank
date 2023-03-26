// https://www.hackerrank.com/contests/round-2-holiday-cup/challenges/skyline

object Solution {

    def main(args: Array[String]) {
        readInt;
        println(isPerfect(readLine.split(" ").map(_.toInt)));
    }
    
    def isPerfect(arr:Array[Int]):String = {
        val L = arr.toList;
        if(arr.size % 2 == 0 || L != L.reverse) return "Not perfect";
        val m = arr.size/2;
        for(i <- 0 until m) if(arr(i) >= arr(i+1)) return "Not perfect";
        return "Perfect";
    }
}
