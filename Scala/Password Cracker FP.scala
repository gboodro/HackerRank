// https://www.hackerrank.com/challenges/password-cracker-fp

import scala.collection.mutable.HashMap;

object Solution{

    var mem = new HashMap[Integer, Tuple2[Boolean, String]]();
    var dict = Set():Set[String]; 

    def main(arg:Array[String]) = {
        val t = readLine.toInt;
        for(i <- 1 to t){
            readLine;
            dict = readLine.split(" ").toSet;
            println(f(readLine, "")._2);
            mem.clear;
        }
    }

    def f(t:String, acc:String):Tuple2[Boolean, String] = {
        if(mem.contains(t.size)) 
            return mem(t.size);
        if(t.isEmpty) 
            return (true, acc.trim);
        for(p <- dict) 
            if(t.startsWith(p)){
                val cur = f(t.substring(p.length), acc + " " + p);
                if(cur._1){
                    mem(t.size) = cur;
                    return cur;
                }
            }
        mem(t.size) = (false, "WRONG PASSWORD");
        return (false, "WRONG PASSWORD");
    }

}