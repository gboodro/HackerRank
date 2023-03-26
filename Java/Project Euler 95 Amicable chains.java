// https://www.hackerrank.com/contests/projecteuler/challenges/euler095

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int[] sig;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        sig = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int j = i*2; j <= n; j += i){
                sig[j] += i;
            }
        }
        int maxChain = 0, maxI = 0;
        for(int i = 2; i <= n; i++){
            int curChain = chainLen(i);
            if(curChain > maxChain){
                maxChain = curChain;
                maxI = i;
            }
        }
        System.out.println(maxI);
    }
    
    static int chainLen(int n){
        HashSet<Integer> hit = new HashSet();
        int nn = n, len = 0;
        try{
            while(hit.add(nn)){
                nn = sig[nn];
                len++;
            }
            return nn == n ? len:0;
        }catch(ArrayIndexOutOfBoundsException e){
            return 0;
        }
    }
}