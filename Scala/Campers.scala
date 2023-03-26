// https://www.hackerrank.com/contests/countercode/challenges/campers

object Solution {

    def main(args: Array[String]) {
        val Array(n, k) = readLine.split(" ").map(_.toInt);
        val ks = readLine.split(" ").map(_.toInt).sorted;
        var s = 0;
        var pk = -1;
        for(k <- ks){
            s += (k - pk - 2) / 2 + 1;
            pk = k;
        } 
        s += (n - pk) / 2;
        println(s);
    }
}