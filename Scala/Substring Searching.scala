// https://www.hackerrank.com/challenges/kmp-fp

import scala.annotation.tailrec;
object Solution {
	var T = new Array[Int](0);
    def main(args: Array[String]) {
        val t = readLine.toInt;
      	for(i<-1 to t){
        	if(g(readLine.toCharArray)) println("YES");
          	else println("NO");
        }
    }
	
  	def g(w:Array[Char]):Boolean = {
      	T = new Array[Int](w.size);
      	var pos = 2;
      	var cnd = 0;
      	val wLen = w.size;
      	T(0) = -1;
      	T(1) = 0;
      	while(pos < wLen){
          	if(w(pos - 1) == w(cnd)){
          		cnd += 1;
          		T(pos) = cnd;
            	pos += 1;
          	}
          	else if(cnd > 0)
            	cnd = T(cnd);
          	else{
              	T(pos) = 0;
              	pos += 1;
            }
      	}
      	return f(0, 0, readLine.toCharArray, w);
    }
  
  	@tailrec
  	def f(i:Int, m:Int, w:Array[Char], s:Array[Char]):Boolean = {
      	if(m+i<s.size)
          	if(w(i)==s(m+i))
          		if(i==w.size-1) return true;
          		else return f(i+1, m, w, s);
          	else if(T(i) > -1) 
          		return f(T(i), m+i-T(i), w, s);
          	else
          		return f(0, m+i-T(i), w, s);
        else
          	return false;
    }
  
}