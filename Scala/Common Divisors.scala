// https://www.hackerrank.com/challenges/common-divisors

object Solution {

    def main(args: Array[String]) {
    	val t = readLine.toInt;
      	for(i <- 1 to t) println(f());
    }
  	
  	def f():Int = {
      	val nums = readLine.split(" ");
      	return numDivs(gcd(nums(0).toInt, nums(1).toInt));
    }
  
  	def gcd(a:Int, b:Int):Int = {
      	if(b == 0) return a;
      	else return gcd(b, a%b);
    }
  
  	def numDivs(n:Int):Int = {
      	var a = 1;
      	var divs = 0;
      	while(a*a < n){
          	if(n % a == 0){
              	divs += 2;
            }
          	a+=1;
        }
      	if(a*a == n) divs += 1;
      	return divs;
    }
}