// https://www.hackerrank.com/challenges/super-digit

object Solution{
    def main(args:Array[String]){
        val Array(n, k) = readLine.split(" ");
        val d = n.toCharArray.toList.map(_.toString.toLong).foldLeft(0L)(_+_);
        println(ds(d * k.toLong));
    }
    def ds(n:Long):Long = {
        if(n < 10) return n;
        else return ds(n%10 + ds(n/10));
    }
}