// https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles

object Solution {
    
    def drawTriangles(n:Int, r:Int, curR:Int, curC:Int):List[Tuple2[Int, Int]] = {
        if(n == 0)
            init(r, curR, curC)
        else
            drawTriangles(n-1, r/2, curR, curC) ++ drawTriangles(n-1, r/2, curR + r/2, curC - r/2) ++ drawTriangles(n-1, r/2, curR+r/2, curC + r/2)
    }
    
    def init(r:Int, curR:Int, curC:Int):List[Tuple2[Int, Int]] = {
        def loop(a:Int, r:Int, row:Int, col:Int):List[Tuple2[Int, Int]] = {
            if(a > r) List()
            else listEm(row, col, a*2-1) ++ loop(a+1, r, row+1, col-1)
        }
        loop(1, r, curR, curC)
    }
        
    def listEm(row:Int, col:Int, a:Int):List[Tuple2[Int, Int]] = {
        if(a == 0) List()
        else (row, col)::listEm(row, col+1, a-1)
    }
    
    def main(args: Array[String]) {
        def loop(curR:Int, curC:Int, maxR:Int, maxC:Int, tri:List[Tuple2[Int, Int]]):Int = {
            if(curR > maxR)
                0
            else if(curC > maxC){
                println()
                loop(curR+1, 0, maxR, maxC, tri)
            }else{
                print(if(tri.contains((curR, curC))) "1" else "_")
                loop(curR, curC+1, maxR, maxC, tri)
            }
        }
        loop(0, 0, 31, 62, drawTriangles(readInt(), 32, 0, 31))
    }
}