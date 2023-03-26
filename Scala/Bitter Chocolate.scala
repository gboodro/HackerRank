// https://www.hackerrank.com/challenges/bitter-chocolate

object Solution {
    
    var mem = Array.fill(26, 26, 26)(null:String)
        
    def main(args:Array[String]){
        mem(1)(0)(0) = "LOSE"
        val t = readLine.toInt;
        for(i <- 1 to t){
            val arr = readLine.split(" ").map(x => x.toInt);
            println(f(arr(0), arr(1), arr(2)))
        }
    }
    
    def f(r1:Int, r2:Int, r3:Int):String = {
        if(mem(r1)(r2)(r3) != null) return mem(r1)(r2)(r3)
        for(i <- r3-1 to 0 by -1)
            if(f(r1, r2, i).equals("LOSE")){
                mem(r1)(r2)(r3) = "WIN"
                return "WIN"
            }
        for(i <- r2-1 to 0 by -1)
            if(f(r1, i, Math.min(i, r3)).equals("LOSE")){
                mem(r1)(r2)(r3) = "WIN"
                return "WIN"
            }
        
        for(i <- r1-1 to 1 by -1)
            if(f(i, Math.min(i, r2), Math.min(i, r3)).equals("LOSE")){
                mem(r1)(r2)(r3) = "WIN"
                return "WIN"
            }
        mem(r1)(r2)(r3) = "LOSE"
        return "LOSE"
    }
}