// https://www.hackerrank.com/contests/lambda-calculi-9/challenges/string-reductions

object Solution {

    def main(args: Array[String]) {
        println(f(readLine));
    }
    
    def f(L:String):String = {
        if(L.isEmpty) return "";
        return L.charAt(0) + f(L.replaceAll(L.charAt(0)+"", ""));
    }
}