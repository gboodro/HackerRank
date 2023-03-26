// https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/4-thought

object Solution {
    val mem = Map[Int, String](256 -> "4 * 4 * 4 * 4", 68 -> "4 * 4 * 4 + 4", 60 -> "4 * 4 * 4 - 4", 16 -> "4 * 4 * 4 / 4", 32 -> "4 * 4 + 4 * 4", 24 -> "4 * 4 + 4 + 4", 17 -> "4 * 4 + 4 / 4", 0 -> "4 * 4 - 4 * 4", 8 -> "4 * 4 - 4 - 4", 15 -> "4 * 4 - 4 / 4", 1 -> "4 * 4 / 4 / 4", 9 -> "4 + 4 + 4 / 4", -8 -> "4 + 4 - 4 * 4", 7 -> "4 + 4 - 4 / 4", 4 -> "4 + 4 / 4 / 4", -16 -> "4 - 4 * 4 - 4", -60 -> "4 - 4 * 4 * 4", -1 -> "4 - 4 - 4 / 4", 2 -> "4 / 4 + 4 / 4", -7 -> "4 / 4 - 4 - 4", -15 -> "4 / 4 - 4 * 4", -4 -> "4 / 4 / 4 - 4");
    
    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val n = readInt;
            if(mem.contains(n)){ 
                println(mem(n) + " = " + n);
            }else{ 
                println("no solution");
            }
        }
    }
}