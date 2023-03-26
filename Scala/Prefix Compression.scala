// https://www.hackerrank.com/contests/lambda-calculi-oct14/challenges/prefix-compression

object Solution {

    def main(args: Array[String]) {
        println(getRes(readLine.toCharArray.toList, readLine.toCharArray.toList, List()).mkString("\n"));
    }
    def getRes(a:List[Char], b:List[Char], acc:List[Char]):List[String] = {
        if(a.isEmpty || b.isEmpty || a.head != b.head){
            return List(acc.size+" "+acc.reverse.mkString(""), a.size+" "+a.mkString(""), b.size+" "+b.mkString(""));
        } else {
            return getRes(a.tail, b.tail, a.head::acc);
        }
    }
}