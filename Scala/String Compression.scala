// https://www.hackerrank.com/challenges/string-compression

import scala.annotation.tailrec;
object Solution{
    def main(args:Array[String]){
        println(getMes(readLine.toCharArray.toList));
    }
    def getMes(L:List[Char]):String = {
        def mes(c:Char, y:List[Char], acc:List[String], count:Int):String = y match {
            case List() =>  if(count == 1)
                                return acc.reverse.mkString("") + c;
                            else
                                return acc.reverse.mkString("") + c + count;
            case x::xs  =>  if(x == c) 
                                return mes(x, xs, acc, count+1);
                            else if(count != 1) 
                                return mes(x, xs, (c.toString+count)::acc, 1);
                            else 
                                return mes(x, xs, c.toString::acc, 1);
        }
        return mes(L.head, L.tail, List(), 1);
    }
}