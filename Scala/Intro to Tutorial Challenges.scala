// https://www.hackerrank.com/challenges/tutorial-intro

object Solution {

    def main(args: Array[String]) {
        val tar = readLine;
        readLine;
        println(f(readLine.split(" ").toList, tar, 0));
    }
    
    def f(a:List[String], t:String, i:Int):Int = a match {
        case List() => i;
        case x::xs => if(x.equals(t)) i else f(xs, t, i+1);
    }
}