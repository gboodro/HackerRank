// https://www.hackerrank.com/challenges/eval-ex

object Solution {

def f(x: Float):Float = {   
    def loop(x:Float, i:Int, s:Float):Float = {
        if(i < 0)
            s
        else
            loop(x, i-1, exp(x, i) + s)
    }
    loop(x, 9, 0)
}

def exp(x:Float, i:Int):Float = {
    if(i == 0) 1
    else x/i*exp(x, i-1)
}

def main(args: Array[String]) {
       var n = readInt
       (1 to n) foreach(x=> println(f(readFloat())))
    }
}
