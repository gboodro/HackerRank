// https://www.hackerrank.com/contests/projecteuler/challenges/euler038

import java.util.*;
class Solution{
    public static void main(String[] args){new Solution();}
    Solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        for(int i = 2; i < n; i++)if(pan(i, k))System.out.println(i);
    }
    boolean pan(int n, int k){
        String t = "";
        int i = 1;
        while(t.length() < k){
            t += i++ * n;
        }
        return t.length() == k && isPan(t, k);
    }
    boolean isPan(String t, int k){
        for(int i = 1; i <= k; i++)if(!t.contains(""+i)) return false;
        return true;
    }
}