// https://www.hackerrank.com/contests/projecteuler/challenges/euler039

import java.util.*;
class Solution{
    public static void main(String... args){
        new Solution();
    }
    Solution(){
        long[] ct = new long[5000001];
        for(long r = 1; r*r < ct.length; r++){
            for(long s = 1; s < r && 2*r*r + 2*r*s < ct.length; s++){
                if(gcd(r*r - s*s, 2*r*s) == 1){
                    long p = 2*r*r + 2*r*s;
                    for(long k = p; k < ct.length; k+=p) ct[(int)k]++;
                }
            }
        }
        long max = 0;
        for(int i = 12; i < ct.length; i++){
            if(ct[i] > max){
                max = ct[i];
                ct[i] = i;
            }else{
                ct[i] = ct[i-1];
            }
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;)
            System.out.println(ct[in.nextInt()]);
    }
    long gcd(long a, long b){return b==0?a:gcd(b, a%b);}
}