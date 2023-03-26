// https://www.hackerrank.com/contests/projecteuler/challenges/euler036

import java.util.*;
class Solution{
    public static void main(String[] args){
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int s = 0;
        for(int i = 1; i < n; i++)if(palTwo(i, k))s += i;
        System.out.println(s);
    }
    boolean palTwo(int n, int k){        
        return isPal(n+"") && isPal(Integer.toString(n, k));
    }
    boolean isPal(String s){
        int len = s.length()/2;
        for(int i = 0; i <= len; i++)if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    }
}