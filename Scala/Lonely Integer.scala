// https://www.hackerrank.com/challenges/lonely-integer

object Solution {

    def main(args: Array[String]) {
        readLine;
        println(f(readLine.split(" ").toList.map(x => x.toInt), List()));
    }
    
    def remove(num: Int, list: List[Int]) = list diff List(num);
    
    def f(n:List[Int], a:List[Int]):Int = n match{
        case List() => a.head;
        case _ => if(a.contains(n.head)) f(n.tail, remove(n.head, a)) else f(n.tail, n.head::a);
    }
}