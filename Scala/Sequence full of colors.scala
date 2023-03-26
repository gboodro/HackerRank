// https://www.hackerrank.com/contests/lambda-calculi-oct14/challenges/sequence-full-of-colors

object Solution {

    def main(args: Array[String]) {
        val t = readInt;
        for(i <- 1 to t)
            if(fullOfColors(readLine.toCharArray.toList, 0, 0, 0, 0)) 
                println("True");
            else 
                println("False");
    }
    def fullOfColors(L:List[Char], r:Int, g:Int, y:Int, b:Int):Boolean = L match {
        case List() => return r == g && y == b;
        case 'R'::xs => return r <= g && fullOfColors(xs, r+1, g, y, b);
        case 'G'::xs => return g <= r && fullOfColors(xs, r, g+1, y, b);
        case 'Y'::xs => return y <= b && fullOfColors(xs, r, g, y+1, b);
        case 'B'::xs => return b <= y && fullOfColors(xs, r, g, y, b+1);
        case _ => false;
    }
}