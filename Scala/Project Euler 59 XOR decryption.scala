// https://www.hackerrank.com/contests/projecteuler/challenges/euler059

object Solution {
    val common = Set("and", "the", "a", "to", "is", "by", "but", "can", "be", "he", "she", "i", "me", "we", "they", "are", "this", "not", "no", "yes", "has", "had", "will", "of", "you", "your", "use", "ok", "okay", "quick", "brown", "fox", "jumps", "over", "lazy", "dog", "for", "yet", "or", "off", "in", "Your", "task", "has", "been", "made", "easy", "as", "encryption", "key", "consists", "three", "lower", "plain", "text", "must", "contain", "common", "english", "characters", "brackets", "symbols", "find", "it");

    val punc = Set('.', ',', '"', '-', '+', '=', '(', ')', '*', '^', '&', '%', '$', '#', '@', '!', ':', ';');
    def main(args: Array[String]) {
        val n = readInt;
        val L = readLine.split(" ").map(_.toInt).toList;
        println(getKey(L));
    }
    def countWords(s:String):Boolean = {
        val words = s.toCharArray.toList.filter(x => !punc.contains(x)).mkString("").split(" ").toList;
        return  words.size * 7 > s.size && words.filter(x => common.contains(x.toLowerCase)).size >= 5;
    }
    def getKey(L:List[Int]):String = {
        val a = 'a'.toInt;
        val z = 'z'.toInt;
        for(i <- z to a by -1){
            for(j <- a to z){
                if(j != i){
                    for(k <- a to z){
                        if(k != i && k != j){
                            if(countWords(decrypt(L, i, j, k, List()))){
                                return i.toChar + "" + j.toChar + "" + k.toChar;
                            }
                        }
                    }
                }
            }
        }
        return "" + 1/0;
    }
    def decrypt(L:List[Int], i:Int, j:Int, k:Int, acc:List[Int]):String = L match {
        case List() => return acc.reverse.map(_.toChar).mkString("");
        case x::xs  => return decrypt(xs, j, k, i, (i^x)::acc);
    }
}