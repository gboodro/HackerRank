// https://www.hackerrank.com/contests/w4/challenges/palindrome-index

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(f(in.next()));
    }
    
    static int f(String s){
        if(isPal(s)) return -1;
        int sLen = s.length();
        boolean[] vert = new boolean[sLen];
        Fenwick diag = new Fenwick(sLen), adiag = new Fenwick(sLen);
        if(s.charAt(0) == s.charAt(sLen-2)) adiag.update(1, 1);
        if(s.charAt(sLen-1) == s.charAt(1)) diag.update(sLen, 1);
        vert[0] = s.charAt(0) == s.charAt(sLen-1);
        for(int i = 1; i < sLen-1; i++){
            vert[i] = vert[i-1] && s.charAt(i) == s.charAt(sLen-1-i);
            if(s.charAt(i) == s.charAt(sLen-i)) diag.update(i+1, 1);
            if(s.charAt(i) == s.charAt(sLen-i-2)) adiag.update(i+1, 1);
        }
        for(int i = 0; i < sLen && vert[i]; i++){
            if(2*(i+1) + diag.rangeQuery(i+1, sLen-i-1) >= sLen - 1) return i+1;
            else if(2*(i+1) + adiag.rangeQuery(i+1, sLen-i-2) >= sLen - 1) return sLen-i-2;
        }
        return diag.rangeQuery(0, sLen+1) == sLen - 1 ? 0 : sLen-1;
    }
    
    static boolean isPal(String s){
        int sLen = s.length();
        for(int i = 0; i*2 <= sLen; i++)
            if(s.charAt(i) != s.charAt(sLen-i-1))
                return false;
        return true;
    }
    
    private static class Fenwick {
        int[] tree;
        
        public Fenwick(int n){
            tree = new int[n+2];
        }

        public int query(int idx){
            int sum = 0;
            while(idx > 0){
                sum += tree[idx];
                idx -= (idx & -idx);
            }
            return sum;
        }

        public int rangeQuery(int left, int right){
            return query(right) - query(left-1);
        }

        void update(int idx, int val){
            while(idx < tree.length){
                tree[idx] += (short)val;
                idx += (idx & -idx);
            }
        }
    }
}