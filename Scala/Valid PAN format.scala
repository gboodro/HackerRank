// https://www.hackerrank.com/challenges/valid-pan-format

object Solution {

    def main(args: Array[String]) {
        val t = readLine.toInt;
        for( i <- 1 to t) println(valid(readLine.toList, List(true, true, true, true, true, false, false, false, false, true)));
    }
    
    def valid(pan:List[Char], a:List[Boolean]):String = pan match {
        case List() => "YES";
        case x::xs  => if(valEle(x, a.head)) valid(xs, a.tail) else "NO";
    }
    
    def valEle(a:Char, b:Boolean):Boolean = b match {
        case true => a >= 'A' && a <= 'Z';
        case false => a >= '0' && a <= '9';
    }
}