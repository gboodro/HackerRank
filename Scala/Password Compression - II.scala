// https://www.hackerrank.com/contests/lambda-calculi-10/challenges/password-compression-ii

object Solution {

    def main(args: Array[String]) {
        println(readLine.split(" ").map(x => take("", x)).mkString(""));
    }
    def take(i:String, s:String):Char = {
        if(s.charAt(0) <= '9') return take(i+s.charAt(0), s.substring(1));
        if(i.toInt < s.size) return s.charAt(i.toInt);
        return ' ';
    }
}