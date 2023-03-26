// https://www.hackerrank.com/contests/w10/challenges/cipher

object Solution {

    def main(args: Array[String]) {
        val Array(n, k) = readLine.split(" ").map(_.toInt);
        println(decode(n, k, readLine.toCharArray.map(_.toString.toInt)));
    }
    def decode(n:Int, k:Int, a:Array[Int]):String = {
        var s = new Array[Int](n);
        var pre = 0;
        for(i <- 0 until s.size){
            if(i >= k) pre ^= s(i-k);
            s(i) = pre ^ a(i);
            pre ^= s(i);
        }
        return s.toList.mkString("");
    }
}