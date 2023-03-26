// https://www.hackerrank.com/challenges/maximizing-xor

object Solution {

    def maxXor(l: Int, r: Int): Int = {
        var max = 0;
        for(i <- l to r)
            for(j <- i to r)
                max = Math.max(max, i ^ j)
        return max
    }

    def main(args: Array[String]) {
        var _l:Int = Console.readInt
        var _r:Int = Console.readInt
        val res = maxXor(_l, _r)
        println(res)
    }
}
