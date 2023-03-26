// https://www.hackerrank.com/challenges/fractal-trees

object Solution {

    def drawTree(n:Int, r:Int, curR:Int, curC:Int):List[Tuple2[Int, Int]] = {
        def loop(i:Int, n:Int, r:Int, curR:Int, curC:Int):List[Tuple2[Int, Int]] = {
            if(i == r) leftRight(n, r, curR, curC+1, 1) ++ leftRight(n, r, curR, curC-1, -1);
            else (curR, curC)::loop(i+1, n, r, curR-1, curC);
        }
        if(n == 0) List();
        else loop(0, n, r, curR, curC);
    }
    
    def leftRight(n:Int, r:Int, curR:Int, curC:Int, dir:Int):List[Tuple2[Int, Int]] = {
        def loop(i:Int, n:Int, r:Int, curR:Int, curC:Int, dir:Int):List[Tuple2[Int, Int]] = {
            if(i == r)
                drawTree(n-1, r/2, curR, curC-dir);
            else
                (curR, curC)::loop(i+1, n, r, curR-1, curC+dir, dir);
        }
        loop(0, n, r, curR, curC, dir);
    }
    
    def main(args: Array[String]) {
        def loop(curR:Int, curC:Int, maxR:Int, maxC:Int, tree:List[Tuple2[Int, Int]]):Int = {
            if(curR > maxR)
                0
            else if(curC > maxC){
                println()
                loop(curR+1, 0, maxR, maxC, tree)
            }else{
                print(if(tree.contains((curR, curC))) "1" else "_")
                loop(curR, curC+1, maxR, maxC, tree)
            }
        }
        loop(0, 0, 62, 99, drawTree(readInt(), 16, 62, 49))
    }
}