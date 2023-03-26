// https://www.hackerrank.com/challenges/reverse-game

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            val Array(n, k) = readLine.split(" ").map(_.toInt);
            var ind = 0;
            var a = n-1;
            var b = 0;
            while(a != k && b!= k){
                a-=1;
                b+=1;
                ind+=2;
            }
            if(a == k){
                println(ind);
            }else{
                println(ind+1);
            }
        }
    }
}