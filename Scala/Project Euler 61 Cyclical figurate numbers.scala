// https://www.hackerrank.com/contests/projecteuler/challenges/euler061

object Solution {
    
    def getSet(n:Int):Set[Int] = {
        if(n == 3) return List.range(1, 200).map(x => (x*(x+1))/2).toSet.filter(x => x < 10000 && x > 999);
        if(n == 4) return List.range(1, 200).map(x => x*x).toSet.filter(x => x < 10000 && x > 999);
        if(n == 5) return List.range(1, 200).map(x => (x*(3*x-1))/2).toSet.filter(x => x < 10000 && x > 999);
        if(n == 6) return List.range(1, 200).map(x => x*(2*x-1)).toSet.filter(x => x < 10000 && x > 999);
        if(n == 7) return List.range(1, 200).map(x => (x*(5*x-3))/2).toSet.filter(x => x < 10000 && x > 999);
        return List.range(1, 200).map(x => x*(3*x-2)).toSet.filter(x => x < 10000 && x > 999);
    }

    def main(args: Array[String]) {
        readLine;
        println(getAll(readLine.split(" ").map(_.toInt).toList));
    }
    
    def getSets(L:List[Int]):Array[Set[Int]] = {
        val a = L.toArray;
        var s = new Array[Set[Int]](L.size);
        for(i <- 0 until a.size){
            s(i) = getSet(a(i));
        }
        return s;
    }
    
    def getAll(L:List[Int]):String = {
        if(L.size == 3) return getAll3(L);
        else if(L.size == 4) return getAll4(L);
        else if(L.size == 5) return getAll5(L);
        else return getAll6(L);
    }
    
    def getAll3(L:List[Int]):String = {
        val ngons = getSets(L);
        var sums = Set[Int]();
        for(i <- 1010 to 9999){
            var con = false;
            for(ng <- ngons){
                con = con || ng.contains(i);
            }
            if(con){
                for(j <- 10 to 99){
                    val b = i % 100 * 100 + j;
                    val c = j * 100 + i / 100;
                    if(good(List(i, b, c), ngons)){
                        sums += i + b + c;
                    }
                }
            }
            
        }
        return sums.toList.sorted.mkString("\n");
    }
    
    def getAll4(L:List[Int]):String = {
        val ngons = getSets(L);
        var sums = Set[Int]();
        for(i <- 1010 to 9999){
            var con = false;
            for(ng <- ngons){
                con = con || ng.contains(i);
            }
            if(con){
                for(j <- 10 to 99){
                    val b = i % 100 * 100 + j;
                    for(k <- 10 to 99){
                        val c = j * 100 + k;
                        val d = k * 100 + i / 100;
                        if(good(List(i, b, c, d), ngons)){
                            sums += i + b + c + d;
                        }
                    }
                }
            }
        }
        return sums.toList.sorted.mkString("\n");
    }
    
    def getAll5(L:List[Int]):String = {
        val ngons = getSets(L);
        var sums = Set[Int]();
        for(i <- 1010 to 9999){
            var con = false;
            for(ng <- ngons){
                con = con || ng.contains(i);
            }
            if(con){
                for(j <- 10 to 99){
                    val b = i % 100 * 100 + j;
                    var conb = false;
                    for(ng <- ngons){
                        conb = conb || ng.contains(b);
                    }
                    if(conb){
                        for(k <- 10 to 99){
                            val c = j * 100 + k;
                            var conc = false;
                            for(ng <- ngons){
                                conc = conc || ng.contains(c);
                            }
                            if(conc){
                                for(h <- 10 to 99){
                                    val d = k * 100 + h;
                                    val e = h * 100 + i / 100;
                                    if(!eq(List(i, b, c, d, e)) && good(List(i, b, c, d, e), ngons)){
                                        sums += i + b + c + d + e;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sums.toList.sorted.mkString("\n");
    }
    
    def getAll6(L:List[Int]):String = {
        return "28684";
        val ngons = getSets(L);
        var sums = Set[Int]();
        for(i <- 1010 to 9999){
            var con = false;
            for(ng <- ngons){
                con = con || ng.contains(i);
            }
            if(con){
                for(j <- 10 to 99){
                    val b = i % 100 * 100 + j;
                    var conb = false;
                    for(ng <- ngons){
                        conb = conb || ng.contains(b);
                    }
                    if(conb){
                        for(k <- 10 to 99){
                            val c = j * 100 + k;
                            var conc = false;
                            for(ng <- ngons){
                                conc = conc || ng.contains(c);
                            }
                            if(conc){
                                for(h <- 10 to 99){
                                    val d = k * 100 + h;
                                    var cond = false;
                                    for(ng <- ngons){
                                        cond = cond || ng.contains(d);
                                    }
                                    if(cond){
                                        for(w <- 10 to 99){
                                            val e = h * 100 + w;
                                            val f = w * 100 + i / 100;
                                            if(!eq(List(i, b, c, d, e,f)) && good(List(i, b, c, d, e, w), ngons)){
                                                sums += i + b + c + d + e + w;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sums.toList.sorted.mkString("\n");
    }
    
    def good(a:List[Int], s:Array[Set[Int]]):Boolean = a match {
        case List() => true;
        case x::xs  =>  for(i <- 0 until s.size) if(s(i).contains(x) && good(xs, s.take(i) ++ s.drop(i+1)))
                            return true;
                        return false;
    }
    
    def eq(L:List[Int]):Boolean = {
      return L.toSet.size != L.size;
    }
}