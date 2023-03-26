// https://www.hackerrank.com/challenges/uk-and-us

object Solution {

    def main(args: Array[String]) {
        val n = readLine.toInt;
        var x = List():List[String];
        for( i <- 1 to n){
            x = (readLine)::x;
        }
        val t = readLine.toInt;
        var y = List():List[String];
        for( j <- 1 to t) y = (readLine)::y;
        f(x, y.reverse);
    }

    def f(x:List[String], y:List[String]):Int = y match {
        case List() => 0;
        case z::zs  => println(g(x, z.substring(0, z.length-2))); f(x, zs);
    }

    def g(x:List[String], z:String):Int = x match {
        case List() => 0;
        case w::ws => g(ws, z) + h(w.split(" ").toList, z);
    } 
    
    def h(x:List[String], z:String):Int = x match {
        case List() => 0;
        case w::ws => h(ws, z) + (if(w.equals(z+"ze") || w.equals(z+"se")) 1 else 0);
    } 
}