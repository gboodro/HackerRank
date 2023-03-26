// https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers

object Solution {
    
    def numberOfWays(X:Int,N:Int):Int = {
       numberOfWays(X, N, 1);
    }
    
    def numberOfWays(X:Int,N:Int,A:Int):Int = {
        if(X == 0){
            1;
        }else if(X > 0 && X >= exp(A, N)){
            numberOfWays(X, N, A+1) + numberOfWays(X - exp(A, N), N, A+1);
        }else{
            0;
        }
    }
    
    def exp(A:Int, P:Int):Int = {
        if(P == 0){
            1;
        }else{
            A*exp(A, P-1);
        }
    }

    def main(args: Array[String]) {
       println(numberOfWays(readInt(),readInt()))
    }
}