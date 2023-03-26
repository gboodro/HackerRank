// https://www.hackerrank.com/challenges/gem-stones

object Solution{
    def main(args:Array[String]){
        val n = readLine.toInt-1
        var gem = readLine.toCharArray.toSet
        for(i <- 1 to n) gem = inter(gem, readLine.toCharArray.toSet)
        println(gem.size)
    }
    
    def inter(a:Set[Char], b:Set[Char]):Set[Char] = {
        var L = List():List[Char]
        for(i <- a) if(b.contains(i))
            L = i::L
        return L.toSet
    }
}