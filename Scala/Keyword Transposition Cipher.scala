// https://www.hackerrank.com/challenges/keyword-transposition-cipher

object Solution{
    def main(args:Array[String]){
        val n = readInt;
        for(i <- 1 to n)println(decode(readLine, readLine split " "));
    }
    def decode(key:String, message:Array[String]):String = {
        val map = getCipher(key toCharArray);
        var original = "";
        for(i <- message)
            original += " " + decrypt(map, i.toCharArray);
        return original trim;
    }
    def decrypt(m:Map[Char, Char], s:Array[Char]):String = {
        var d = "";
        for(i <- s) d += m(i);
        return d;
    }
    def getCipher(k:Array[Char]):Map[Char, Char] = {
        var m = Map[Char, Char]();
        var dupeless = "";
        var used = Set[Char]();
        for(i <- k) if(!used.contains(i)){
            used += i;
            dupeless += i;
        }
        var alpha = Set[Char]();
        for(i <- 'A' to 'Z') alpha += i;
        alpha --= used;
        val unused = alpha.toArray.sorted;
        val all = dupeless + unused.mkString("");
        var ball = "";
        val srt = used.toList.sorted;
        for(i <- srt){
            var j = 0;
            while(all.charAt(j) != i) j+=1;
            for(b <- j until all.size by used.size) ball += all charAt b;
        }
        var ch = 'A';
        for(i <- 0 until ball.size){
            m += (ball(i) -> ch);
            ch = (ch.toInt+1).toChar;
        }
        return m;
    }
}