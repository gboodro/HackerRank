// https://www.hackerrank.com/contests/lambda-calculi-10/challenges/flip-the-tree

object Solution {
    var par = new Array[Int](0);
    var lev = new Array[Int](0);
    var lef = new Array[Int](0);
    var rig = new Array[Int](0);
    var fl = new Array[Boolean](0);
    def main(args: Array[String]) {
        val n = readInt;
        par = new Array[Int](n+1);
        lef = new Array[Int](n+1);
        rig = new Array[Int](n+1);
        val rel = readLine.split(" ").map(_.toInt);
        fl = new Array[Boolean](n+1);
        lev = new Array[Int](n+1);
        lev(1) = 1;
        for(i <- 0 until rel.size){
            par(i+2) = rel(i);
            lev(i+2) = lev(rel(i)) + 1;
            if(lef(rel(i)) == 0) lef(rel(i)) = i+2;
            else rig(rel(i)) = i+2;
        }
        val m = readInt;
        for(i <- 1 to m){
            val a = readLine.split(" ").map(_.toInt);
            if(a(0) == 1){
                fl(a(1)) = !fl(a(1));
            }else{
                println(relLoc(a(1), a(2)));
            }
        }   
    }
    
    def relLoc(ch1:Int, ch2:Int):Char = {
        var c1 = ch1;
        var c2 = ch2;
        var p1 = c1;
        var p2 = c2;
        while(lev(c1) > lev(c2)){
            p1 = c1;
            c1 = par(c1);
        }
        while(lev(c2) > lev(c1)){
            p2 = c2;
            c2 = par(c2);
        }
        var relL = true;
        if(c1 == c2){
            if(lev(p1) > lev(p2)){
                relL = lef(p2) == p1;
            }else{
                relL = rig(p1) == p2;
            }
        }else{
            while(c1 != c2){
                p1 = c1;
                p2 = c2;
                c1 = par(c1);
                c2 = par(c2);
            }
            relL = lef(c1) == p1;
        }
        do{
            p1 = c1;
            c1 = par(c1);
            if(fl(p1)) relL = !relL;
        }while(p1 != 1);
        if(relL) return 'L';
        else return 'R';
    }
}