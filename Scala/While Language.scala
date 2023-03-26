// https://www.hackerrank.com/challenges/while-language-fp

import scala.io.Source;
import scala.collection.mutable.HashMap;

object Solution {
  
    var vars = HashMap[String, Long]();
  
    def main(args:Array[String]) = {
        val lines = sanitize(Source.fromInputStream(System.in).getLines)
        runProgram(lines);
        val out = vars.keys.toList.sorted;
        for(i <- out) println(i + " " + vars(i));
    }
  
    def sanitize(L:Iterator[String]):String = {
        var t = "";
        for(i <- L) t += " " + i;
        t = t.replaceAll("while", " @ ");
        t = t.replaceAll("do", "");
        t = t.replaceAll("if", " # ");
        t = t.replaceAll("then", "");
        t = t.replaceAll("else", "");
        t = t.replaceAll("and", " & ");
        t = t.replaceAll("or", " | ");
        t = t.replaceAll("\t", " ");
        t = t.replaceAll("\n", " ");
        t = t.replaceAll(" ", "");
        return t;
    }
    
    def runProgram(t:String):Unit = {
        if(!t.isEmpty){
            if(t.contains(";")){
                var i = 0;
                var ct = 0;
                while(i < t.length && !(t.charAt(i) == ';' && ct == 0)){
                    if(t.charAt(i) == '{')
                        ct += 1;
                    else if(t.charAt(i) == '}')
                        ct -= 1;
                    i += 1;
                }
                run(t.substring(0, i));
                if(i < t.length - 1) 
                    runProgram(t.substring(i+1));
            }else
                run(t);
        }
    }
  
    def run(t:String):Unit = {
        if(!t.isEmpty){
            if(t.charAt(0) == '@'){
                var b = "";
                var i = 2;
                while(t.charAt(i) != ')'){
                    b += t.charAt(i);
                    i+=1;
                }
                val s = t.substring(i+2, t.length-1);
                while(bExp(b)){
                    runProgram(s);
                }
            }else if(t.startsWith("#")){
                var b = "";
                var i = 2;
                while(t.charAt(i) != ')'){
                    b += t.charAt(i);
                    i+=1;
                }
                val s = t.substring(i+2, t.length-1);
                if(bExp(b)){
                    i += 2;
                    val j = i;
                    var ct = 1;
                    var s = "";
                    while(ct != 1 || t.charAt(i) != '}'){
                        s += t.charAt(i);
                        if(t.charAt(i) == '{')
                            ct += 1;
                        else if(t.charAt(i) == '}')
                            ct -= 1;
                        i+=1;
                    }
                    runProgram(s);
                }else{
                    i += 2;
                    var ct = 1;
                    while(ct != 1 || t.charAt(i) != '}'){
                        if(t.charAt(i) == '{')
                            ct += 1;
                        else if(t.charAt(i) == '}')
                            ct -= 1;
                        i+=1;
                    }
                    runProgram(t.substring(i+2, t.length-1));
                }
            }else{
                setVar(t);
            }
        }
    }
  
    def setVar(statement:String) = {
        val split = statement.split(":=");
        if(split.size > 1) 
            vars(split(0)) = aExp(split(1).replaceAll("\\(", "").replaceAll("\\)", ""));
    }
  
    def bExp(t:String):Boolean = {
        if(t.equals("false")) return false;
        if(t.equals("true")) return true;
        if(t.contains("|"))
            return t.split("|").toList.map(x => bExp(x)).foldLeft(false)(or);
        if(t.contains("&"))
            return t.split("&").toList.map(x => bExp(x)).foldLeft(true)(and);
        return opR(t);
    }
  
    def aExp(t:String):Long = {
        if(vars.contains(t)) 
            return vars(t);
        var i = t.length - 1;
        if(t.contains("-") || t.contains("+")){
            while(t.charAt(i) != '-' && t.charAt(i) != '+') 
                i-=1;
            return opA(t.charAt(i), t.substring(0, i), t.substring(i+1));
        }else if(t.contains("*") || t.contains("/")){
            while(t.charAt(i) != '*' && t.charAt(i) != '/') 
                i-=1;
            return opA(t.charAt(i), t.substring(0, i), t.substring(i+1));
        }else 
            return t.toLong;
    }
  
    def opA(op:Char, a:String, b:String):Long = op match {
        case '*' => aExp(a) * aExp(b);
        case '/' => aExp(a) / aExp(b);
        case '+' => aExp(a) + aExp(b);
        case  _  => aExp(a) - aExp(b);
    }
  
    def opB(op:Char, a:String, b:String):Boolean = op match {
        case '&'   => bExp(a) && bExp(b);
        case  _    => bExp(a) || bExp(b);
    }
  
    def opR(t:String):Boolean = {
        if(t.contains("<")){
            val s = t.split("<");
            return aExp(s(0)) < aExp(s(1));
        }else{
            val s = t.split(">");
            return aExp(s(0)) > aExp(s(1));
        }
    }
    
    def and(a:Boolean, b:Boolean):Boolean = {a && b}
    
    def or(a:Boolean, b:Boolean):Boolean = {a || b}
  
}