// https://www.hackerrank.com/challenges/reverse-factorization

object Solution {

    def main(args: Array[String]) {
      	val n = readLine.split(" ")(0).toInt;
        f(n, readLine.split(" ").map(x=>x.toInt).sorted.reverse.filter(x => n % x == 0), "");
      	println(-1);
    }
  
  	def f(n:Int, arr:Array[Int], s:String):Unit = {
      	if(n == 1){
          	println(n + " " + s.trim);
          	System.exit(0);
        }else{
          	for( a <- arr ) f(n/a, arr.filter(x => (n/a) % x == 0), n + " " + s);
        }
    }
  
}