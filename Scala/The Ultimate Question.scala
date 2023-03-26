// https://www.hackerrank.com/contests/indeed-prime-codesprint/challenges/the-ultimate-question

object Solution {

    def main(args: Array[String]) {
        val Array(a, b, c) = readLine.split(" ").map(_.toInt)
        if(a+b+c==42)println(a+"+"+b+"+"+c)else if(a+b*c==42)println(a+"+"+b+"*"+c)else if(a*b+c==42)println(a+"*"+b+"+"+c)else if(a*b*c==42)println(a+"*"+b+"*"+c)else println("This is not the ultimate question")
    }
}
