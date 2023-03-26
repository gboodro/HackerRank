// https://www.hackerrank.com/contests/w9/challenges/sansa-and-xor

import java.util.*;
class Solution{
    public static void main(String... args){new Solution();}
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            HashMap<Integer, Boolean> map = new HashMap();
            int n = in.nextInt();
            for(long i = 0; i < n; i++){
                int c = in.nextInt();
                if(map.containsKey(c)) map.put(c, map.get(c) ^ ((i+1) % 2 * (n-i) % 2 % 2 == 1));
                else map.put(c, (i+1) % 2 * (n-i) % 2 % 2 == 1);
            }
            long p = 0;
            for(int k : map.keySet()) if(map.get(k)) p ^= k;
            System.out.println(p);
        }  
    }
}