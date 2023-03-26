// https://www.hackerrank.com/challenges/hackerrank-language

object Solution {

    def main(args: Array[String]) {
        val valid = "C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:BASH:SCALA:ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART:GROOVY:OBJECTIVEC".split(":").toList;
        val t = readLine.toInt;
        for( i <- 1 to t) println(check(readLine.split(" ").toList, valid));
    }
    
    def check(a:List[String], v:List[String]):String = a match {
        case List() => "INVALID";
        case x::xs => if(contains(v, x)) return "VALID" else return check(xs, v);
    }
    
    def contains(v:List[String], x:String):Boolean = v match {
        case List() => false;
        case y::ys => x.equals(y) || contains(ys, x);
    }
}