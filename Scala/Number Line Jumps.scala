// https://www.hackerrank.com/contests/w21/challenges/kangaroo

object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var x1 = sc.nextInt();
        var v1 = sc.nextInt();
        var x2 = sc.nextInt();
        var v2 = sc.nextInt();

        if(v1 != v2 && (x2 - x1) % (v1 - v2) == 0 && (x2 - x1)/(v1 - v2) > 0){
            println("YES");
        }else println("NO");
    }
}
