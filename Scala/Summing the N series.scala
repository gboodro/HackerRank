// https://www.hackerrank.com/challenges/summing-the-n-series

object Solution{
  def main(args:Array[String]){
    	val t = readLine.toInt;
    	for(i <- 1 to t) println(sqr(BigInt(readLine.toLong)));
  }
  
  def sqr(t:BigInt):BigInt = {
    	return (t*t).mod(1000000007);
  }
}