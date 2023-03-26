// https://www.hackerrank.com/challenges/basic-cryptanalysis

import scala.io.Source;
import scala.collection.mutable.HashSet;
object Solution{
    val a = Array.fill(26){new HashSet[String]()};
    def main(args:Array[String]){
        val file = Source.fromFile("dictionary.lst");
        val d = file.getLines mkString " " split " ";
        file.close;
        for(t <- d)
            a(t.size) += t.toLowerCase;
        dfs(readLine split " " toList);
    }
    def dfs(L:List[String]){
        def aux(LS:List[String], m:Map[Char, Char], acc:String):Unit = LS match {
            case List() => println(acc trim); System exit 0;
            case x::xs  => 
                val poss = a(x.size);
                for(i <- poss){
                    val next = nextMap(x, i, m);
                    if(next._1) aux(xs, next._2, acc+" "+i);
                }                
        }
        aux(L, Map(), "");
    }
    def nextMap(a:String, b:String, m:Map[Char, Char]):Tuple2[Boolean, Map[Char, Char]]  = {
        var nm = m;
        for(i <- 0 until a.size){
            if(nm.contains(a(i)) && nm(a(i)) != b(i)) return Tuple2(false, Map());
            else nm += (a(i) -> b(i));
        }
        return Tuple2(true, nm);
    }
}