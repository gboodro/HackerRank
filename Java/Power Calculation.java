// https://www.hackerrank.com/contests/infinitum-sep14/challenges/power-calculation

import java.util.*;
class Solution {
    public static void main(String[] args) {
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            long k = in.nextLong(), n = in.nextLong();
            System.out.println(s(k, n));
        }
    }
    String s(long k, long n){
        int max = (int) Math.min(99, k);
        int sum = 0;
        int c = (int)(k / 100 + 1 % 100);
        int r = (int)(k % 100);
        for(int i = 1; i <= r; i++){
            sum += powMod(i, n) * c;
            sum %= 100;
        }
        c--;
        for(int i = r+1; i <= max; i++){
            sum += powMod(i, n) * c;
            sum %= 100;
        }
        return (sum < 10 ? "0":"") + sum;
    }
    
    int powMod(int a, long p){
        if(p <= 1) return p == 0 ? 1:a % 100;
        if(p % 2 == 1) return powMod(a*a%100, p/2) * a % 100;
        return powMod(a*a%100, p/2);
    }
}