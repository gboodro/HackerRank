// https://www.hackerrank.com/challenges/string-mingling

object Solution{
    def main(args:Array[String]){
        println(readLine.toCharArray.toList.zip(readLine.toCharArray.toList).map(x => x._1 +""+ x._2).mkString(""));
    }
}