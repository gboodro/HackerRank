// https://www.hackerrank.com/challenges/manasa-loves-maths

import scala.collection.mutable.HashSet;

object Solution {
  
	var g = new HashSet[Array[Int]]();

    def main(args: Array[String]) {
      	for(i <- 0 to 999) if(i % 8 == 0) g += ct(pad(i.toString).toCharArray);
        val t = readLine.toInt;
      	for(i <- 1 to t) println(f(readLine));
    }
  
  	def f(t:String):String = {
   		if(t.length <= 2){
          	if(Set(0, 8, 16,61, 24,42, 32,23, 40, 48,84, 56,65, 46,64, 72,27, 80, 88, 96,69).contains(t.toInt)) return "YES";
          	else return "NO";
        }else{
        	if(div8(ct(t.toCharArray))) return "YES";
          	else return "NO";
        }
    }
  
  	def div8(t:Array[Int]):Boolean = {
    	for(arr <- g) if(less(arr, t)) return true;
        return false;
    }
  
  	def ct(t:Array[Char]):Array[Int] = {
    	var a = new Array[Int](10);
      	for(c <- t) a(c.asDigit) += 1;
      	return a;
    }
  
  	def less(a:Array[Int], b:Array[Int]):Boolean = {
    	for(i <- 0 to 9) if(a(i) > b(i)) return false;
        return true;
    }
  
  	def pad(t:String):String = {
      	if(t.length < 3) return pad(t.concat("0"));
      	else return t;
    }
}