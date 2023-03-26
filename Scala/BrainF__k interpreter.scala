// https://www.hackerrank.com/challenges/brainf-k-interpreter-fp

import scala.annotation.tailrec;
object Solution {
    
    var ind = 0;
    var total = 100000;
    var inputList = new Array[Int](0);
    var cell = Array.fill[Int](10000)(0);
    var inputInd = 0;
    
    def main(args: Array[String]) {
        val nums = readLine.split(" ");
        val n = nums(0).toInt; 
        val m = nums(1).toInt;
        val chars = readLine;
        val valid = List('+', '-', '.', ',', '[', ']', '<', '>');
        inputList = new Array(n);
        for(i <- 1 to chars.length-1)
            inputList(i-1) = mod(chars(i-1).toInt);
        var pro = "";
        for(i <- 1 to m){ 
            pro += readLine.toList.filter(x => valid.contains(x)).mkString;
        }
        execute(pro.toList);
    }
    
    def execute(ops:List[Char]):Unit = {
        if(total < 0){
            println("\nPROCESS TIME OUT. KILLED!!!");
            System.exit(0);
        }
        if(!ops.isEmpty){
            val x = ops.head; 
            val xs = ops.tail;
            if(x == '+' || x == '-' || x == ',' || x == '.' || x == '<' || x == '>'){ 
                if(x == '+') 
                    cell(ind) = mod(cell(ind)+1);
                else if(x == '-')
                    cell(ind) = mod(cell(ind)-1);
                else if(x == '.' && total > 0) 
                    print((mod(cell(ind))).toChar);
                else if(x == '<') 
                    ind -= 1;
                else if(x == '>')
                    ind += 1;
                else if(x == ','){
                    cell(ind) = mod(inputList(inputInd));
                    inputInd += 1;
                }
                total -= 1;
                execute(xs); 
            }else if(x == '['){
                val spl = split(xs, List(), 1);
                if(cell(ind) == 0) total -= 2;
                while(cell(ind) != 0){
                    total -= 1;
                    execute(spl._1);
                    total -= 1;
                }
                execute(spl._2);
            }
        }
    }
    
    @tailrec
    def split(ops:List[Char], acc:List[Char], c:Int):Tuple2[List[Char], List[Char]] = {
        if(ops.isEmpty || c == 0) return (acc.tail.reverse, ops);
        val x = ops.head;
        if(x == '[') return split(ops.tail, x::acc, c+1);
        else if(x == ']') return split(ops.tail, x::acc, c-1);
        else return split(ops.tail, x::acc, c);
    }
    
    def mod(c:Int):Int = {
        if(c > 0) return c % 256;
        else return mod(c + 256);
    }
}