// https://www.hackerrank.com/contests/round-1-holiday-cup/challenges/erratic-ants

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t){
            readLine;
            val s = readInt;
            var g = Set[Tuple4[Int, Int, Int, Int]]();
            var i = 0;
            var j = 0;
            for(k <- 1 to s){
                val d = readLine;
                d match {
                    case "N" => {
                        g += Tuple4(i, j, i, j+1);  
                        g += Tuple4(i, j+1, i, j);
                        j+=1;
                    }
                    case "S" => {
                        g += Tuple4(i, j, i, j-1);  
                        g += Tuple4(i, j-1, i, j);
                        j-=1;
                    }
                    case "E" => {
                        g += Tuple4(i+1, j, i, j);  
                        g += Tuple4(i, j, i+1, j);
                        i+=1;
                    }
                    case "W" => {
                        g += Tuple4(i-1, j, i, j);  
                        g += Tuple4(i, j, i-1, j);
                        i-=1;
                    }
                    case _ => {
                        println("Error!")
                    }
                }
            }
            println(minPathLen(0, 0, i, j, g, Set()));
        }
    }
    
    def minPathLen(curI:Int, curJ:Int, endI:Int, endJ:Int, g:Set[Tuple4[Int, Int, Int, Int]], s:Set[Tuple2[Int, Int]]):Int = {
        if(curI == endI && curJ == endJ) return 0;
        var min = 9000;
        if(!s.contains(curI, curJ)){
            val ns = s + Tuple2(curI, curJ);
            if(g.contains(curI, curJ, curI - 1, curJ)){
                min = Math.min(min, minPathLen(curI - 1, curJ, endI, endJ, g, ns));
            }
            if(g.contains(curI, curJ, curI + 1, curJ)){
                min = Math.min(min, minPathLen(curI + 1, curJ, endI, endJ, g, ns));
            }
            if(g.contains(curI, curJ, curI, curJ - 1)){
                min = Math.min(min, minPathLen(curI, curJ - 1, endI, endJ, g, ns));
            }
            if(g.contains(curI, curJ, curI, curJ + 1)){
                min = Math.min(min, minPathLen(curI, curJ + 1, endI, endJ, g, ns));
            }
        }
        return 1 + min;
    }
}