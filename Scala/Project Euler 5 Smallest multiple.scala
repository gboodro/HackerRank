// https://www.hackerrank.com/contests/projecteuler/challenges/euler005

object Solution{
    def main(a:Array[String]){
        val a = Array[Long](1, 1, 2, 3, 2, 5, 1, 7, 2, 3, 1, 11, 
                            1, 13, 1, 1, 2, 17, 1, 19, 1, 1, 1, 
                            23, 1, 5, 1, 3, 1, 29, 1, 31, 2, 1, 
                            1, 1, 1, 37, 1, 1, 1);
        for(i <- 1 until a.size) a(i) *= a(i-1);
        val t = readInt;
        for(i <- 1 to t) println(a(readInt));
    }
}