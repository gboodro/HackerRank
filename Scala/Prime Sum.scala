// https://www.hackerrank.com/challenges/prime-sum

object Solution{

	def main(args:Array[String]){
		val t = readInt;
		for(i <- 1 to t){
			if(f(readLine.split(" ").map(x => x.toLong))) println("Yes");
			else println("No");
		}
	}

	def f(nums:Array[Long]):Boolean = {
        val n = nums(0);
        val k = nums(1);
        if(k == 1) return BigInt(n).isProbablePrime(20);
		if(n / k < 2) return false;
        if(k == 2) return n % 2 == 0 || BigInt(n-2).isProbablePrime(20);;
        return true;
	}
}