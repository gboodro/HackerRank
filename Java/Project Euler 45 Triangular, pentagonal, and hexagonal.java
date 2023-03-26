// https://www.hackerrank.com/contests/projecteuler/challenges/euler045

import java.util.*;
class Solution{
    public static void main(String... args){new Solution();}
    Solution(){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int a = in.nextInt();
        if(a == 3){
            for(long i = 1; i*(i+1) < 2*n; i++){
                long t = i*(i+1)/2;
                if(isSqu(1+24*t) && (1+(long)Math.sqrt(1+24*t)) % 6 == 0) System.out.println(t);
            }
        }else{
            for(long i = 1; i*(2*i-1) < n; i++){
                long t = i*(2*i-1);
                if(isSqu(1+24*t) && (1+(long)Math.sqrt(1+24*t)) % 6 == 0) System.out.println(t);
            }
        }
    }
    boolean isSqu(long n){
        long t = (long)Math.sqrt(n);
        return t*t == n;
    }
}