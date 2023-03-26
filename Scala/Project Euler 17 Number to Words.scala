// https://www.hackerrank.com/contests/projecteuler/challenges/euler017

object Solution{
    val d = Map[Int, String](0->"", 1->"One", 2->"Two", 3->"Three", 4->"Four", 5->"Five", 6->"Six", 7->"Seven", 8->"Eight", 9->"Nine", 
                          10->"Ten", 11->"Eleven", 12->"Twelve", 13->"Thirteen", 14->"Fourteen", 15->"Fifteen", 16->"Sixteen", 17->"Seventeen", 18->"Eighteen", 19->"Nineteen");
    val ten = Map[Int, String](0->"", 2->"Twenty", 3->"Thirty", 4->"Forty", 5->"Fifty", 6->"Sixty", 7->"Seventy", 8->"Eighty", 9->"Ninety");
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t) println(space(letters(readLine)));
    }
    def letters(s:String):String = {
        if(s.length == 13) return "One Trillion";
        else if(s.length > 9) return letters(s.dropRight(9)) + " Billion " + letters(s.substring(s.size-9));
        else if(d.contains(s.toInt)) return d(s.toInt);
        else if(s.length == 2) 
            return ten(s.charAt(0).toString.toInt) + " " + letters(s.substring(1)); 
        else if(s.length == 3)
            if(s.charAt(0) == '0') return letters(s.substring(1));
            else return letters(s.charAt(0)+"") + " Hundred " + letters(s.substring(1));
        else if(s.length < 7) 
            if(s.startsWith("000")) return letters(s.substring(s.size-3));
            else return letters(s.dropRight(3)) + " Thousand " + letters(s.substring(s.size-3));
        else if(s.startsWith("000"))
            return letters(s.substring(s.size-6)); 
        else
            return letters(s.dropRight(6)) + " Million " + letters(s.substring(s.size-6)); 
    }
    def space(s:String):String = {
        if(s.contains("  ")) return space(s.replaceAll("  ", " "));
        return s;
    }
}