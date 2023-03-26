// https://www.hackerrank.com/contests/projecteuler/challenges/euler011

object Solution{
    var max = 0;
    val g = new Array[Array[Int]](20);
    def main(args:Array[String]){
        for(i <- 0 until g.size)
            g(i) = readLine.split(" ").map(_.toInt);
        go(0, 0);
        println(max);        
    }
    
    def go(x:Int, y:Int):Unit = {
        if(x < g.size){
            if(y < g(x).size){
                var down = 1;
                var right = 1;
                var dia = 1;
                var adia = 1;
                var i = 0;
                while(i < 4 && i + x < g.size){
                    down *= g(x+i)(y);
                    i+=1;
                }
                i = 0;
                while(i < 4 && i + y < g(x).size){
                    right *= g(x)(y+i);
                    i+=1;
                }
                i = 0;
                while(i < 4 && i + x < g.size && y - i > 0){
                    dia *= g(x+i)(y-i);
                    i+=1;
                }
                i = 0;
                while(i < 4 && i + x < g.size && y + i < g(x).size){
                    adia *= g(x+i)(y+i);
                    i+=1;
                }
                max = Math.max(max, down);
                max = Math.max(max, right);
                max = Math.max(max, dia);
                max = Math.max(max, adia);
                go(x, y+1);
            }else{
                go(x+1, 0);
            }
        }
    }
}