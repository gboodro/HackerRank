// https://www.hackerrank.com/contests/projecteuler/challenges/euler040

object Solution {
	
	def main(args:Array[String]){
		val t = readInt;
		for(i <- 1 to t)
		  println(readLine.split(" ").map(_.toLong).map(d).toList.foldLeft(1L)(_*_));
	}
	
	def d(i:Long):Long = {
		var n = i;
		var k = 1L;
		var a = 9L;
		while(n > a*k){
			n -= a*k;
			a *= 10;
			k+=1;
		}
		val num = a/9 + (n-1)/k + "";
		return (""+num.charAt(((k + (n-1)%k) % k).toInt)).toLong;
	}

}