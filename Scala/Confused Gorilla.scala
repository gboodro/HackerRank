// https://www.hackerrank.com/contests/infinitum11/challenges/confused-gorilla

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            var a = 0;
            var b = readInt;
            while(a < b){
                println(a + " " + b + "\n" + b + " " + a);
                a+=1;
                b-=1;
            }
            if(a==b) println(a +" "+ b);
        }
    }
}