// https://www.hackerrank.com/contests/projecteuler/challenges/euler004

object Solution{
    var pals = Set[Int]();
    def main(a:Array[String]){
        for(i <- 100 to 999)
            for(j <- i to 999)
                if(pal((i*j).toString))
                    pals += i*j;
        val t = readInt;
        for(i <- 1 to t) println(maxPal(readInt));
    }
    
    def pal(t:String):Boolean = {
        val len = t.size-1;
        for(i <- 0 to t.size/2) if(t.charAt(i) != t.charAt(len-i)) return false;
        return true;
    }
    
    def maxPal(n:Int):Int = {
        var m = n;
        while(!pals.contains(m))m-=1;
        return m;
    }
}