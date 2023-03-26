// https://www.hackerrank.com/challenges/jumping-bunnies

object Solution{
  
  def main(args:Array[String]) {
    	readLine
        println(lcm(1, readLine.split(" ").toList.map(x => x.toLong)))
  }
  
  	def lcm(cur:Long , L:List[Long]):Long = L match {
      	case List() => cur;
      	case x::xs  => return lcm(Lcm(cur, x), xs)
    }
  
  	def Lcm(a:Long, b:Long):Long = {
      	return a/gcd(a, b)*b
    }
  
  	def gcd(a:Long, b:Long):Long = b match {
      	case 0 => a
        case _ => gcd(b, a%b)      
    }
}