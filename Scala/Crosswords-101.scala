// https://www.hackerrank.com/challenges/crosswords-101

object Solution {
    type Dim2Arr = Array[Array[Char]];
    def main(args: Array[String]) {
        val a = new Dim2Arr(10);
        for(i <- 0 until a.size) a(i) = readLine.toCharArray;
        val loc = getLoc(a).toList;
        val words = readLine.split(";").toList;
        val poss = words.permutations;
        for(i <- poss){
            val replace = replacePoss(i, loc, safeCopy(a));
            if(replace._1){
                println(replace._2.map(_.toList.mkString("")).mkString("\n"));
                System.exit(0);
            }
        }
    }
    def getLoc(a:Array[Array[Char]]):Set[Tuple3[Int, Int, Boolean]] = {
        var locs = Set[Tuple3[Int, Int, Boolean]]();
        for(i <- 0 until a.size){
            for(j <- 0 until a(i).size){
                if(a(i)(j) == '-'){
                    if(i == 0){
                        if(a(1)(j) == '-')
                            locs += Tuple3(i, j, true);
                    }else if(i+1 < a.size && a(i+1)(j) == '-' && a(i-1)(j) == '+'){
                        locs += Tuple3(i, j, true);
                    }
                    if(j == 0){
                        if(a(i)(1) == '-')
                            locs += Tuple3(i, j, false);
                    }else if(j+1 < a(i).size && a(i)(j+1) == '-' && a(i)(j-1) == '+'){
                        locs += Tuple3(i, j, false);
                    }
                }
            }
        }
        return locs;
    }
    def replacePoss(c:List[String], loc:List[Tuple3[Int, Int, Boolean]], a:Dim2Arr):Tuple2[Boolean, Dim2Arr] = c match {
        case List() =>  return (true, a);
        case x::xs  =>  val curLoc = loc.head;
                        if(curLoc._3){
                            if(x.size+curLoc._1 > a.size || (x.size+curLoc._1 < a.size && a(x.size+curLoc._1)(curLoc._2) != '+'))
                                return (false, Array());
                            for(i <- 0 until x.size){
                                if(a(i+curLoc._1)(curLoc._2) == '-')
                                    a(i+curLoc._1)(curLoc._2) = x.charAt(i);
                                else if(a(i+curLoc._1)(curLoc._2) != x.charAt(i)){
                                    return (false, Array());
                                }
                            }
                        }else{
                            if(x.size+curLoc._2 > a.size || (x.size+curLoc._2 < a.size && a(curLoc._1)(x.size+curLoc._2) != '+'))
                                return (false, Array());
                            for(i <- 0 until x.size){
                                if(a(curLoc._1)(i+curLoc._2) == '-')
                                    a(curLoc._1)(i+curLoc._2) = x.charAt(i);
                                else if(a(curLoc._1)(i+curLoc._2) != x.charAt(i)){
                                    return (false, Array());
                                }
                            }
                        }
                        return replacePoss(xs, loc.tail, a);
    }
    def safeCopy(a:Dim2Arr):Dim2Arr = {
        val b = new Dim2Arr(a.size);
        for(i <- 0 until b.size){
            b(i) = new Array[Char](10);
            for(j <- 0 until b(i).size){
                 b(i)(j) = a(i)(j);
            }
        }
        return b;
    }
}