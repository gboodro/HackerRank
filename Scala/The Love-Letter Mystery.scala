// https://www.hackerrank.com/challenges/the-love-letter-mystery

object Solution {
	def main(args:Array[String]) {
		val t = readInt;
		for(i <- 1 to t) println(f(readLine.toCharArray.toList));
	}

	def f(n:List[Char]):Int = {
        return count(n, n.reverse, 0);
	}
    
    def count(a:List[Char], b:List[Char], c:Int):Int = a match{
       case List() => return c/2;
       case x::xs => return count(a.tail, b.tail, c + Math.abs(x.toInt-b.head.toInt));
    }
}