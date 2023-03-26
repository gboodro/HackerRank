// https://www.hackerrank.com/contests/projecteuler/challenges/euler047

import java.util.*;
class Solution {

    public static void main(String... args) {
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] p =  getPrimes(n);
        boolean[] arr = new boolean[n+k+1];
        
        if(k == 2){
            for(int i = 0; i < p.length - 1 && p[i]*p[i+1] <= n+k; i++){
                for(long p1 = p[i]; p1*p[i+1] <= n+k; p1 *= p[i]){
                    for(int j = i+1; j < p.length && p1 * p[j] <= n+k; j++){
                        for(long p2 = p[j]; p1*p2 <= n+k; p2*=p[j]){
                            arr[(int)(p1*p2)] = true;
                        }
                    }
                }
            }
        }else if(k == 3){
            for(int i = 0; i < p.length - 2 && p[i]*p[i+1]*p[i+2] <= n+k; i++){
                for(long p1 = p[i]; p1*p[i+1]*p[i+2] <= n+k; p1 *= p[i]){
                    for(int j = i+1; j < p.length-1 && p1 * p[j]*p[j+1] <= n+k; j++){
                        for(long p2 = p[j]; p1*p2*p[j+1] <= n+k; p2*=p[j]){
                            for(int h = j+1; h < p.length && p1 * p2 * p[h] <= n+k; h++){
                                for(long p3 = p[h]; p1*p2*p3 <= n+k; p3 *= p[h]){
                                    arr[(int)(p1*p2*p3)] = true;
                                }
                            }
                        }
                    }
                }
            }
        }else{
            for(int i = 0; i < p.length - 3 && p[i]*p[i+1]*p[i+2]*p[i+3] <= n+k; i++){
                for(long p1 = p[i]; p1*p[i+1]*p[i+2]*p[i+3] <= n+k; p1 *= p[i]){
                    for(int j = i+1; j < p.length-2 && p1*p[j]*p[j+1]*p[j+2] <= n+k; j++){
                        for(long p2 = p[j]; p1*p2*p[j+1]*p[j+2] <= n+k; p2*=p[j]){
                            for(int h = j+1; h < p.length-1 && p1 * p2 * p[h]*p[h+1] <= n+k; h++){
                                for(long p3 = p[h]; p1*p2*p3*p[h+1] <= n+k; p3 *= p[h]){
                                    for(int d = h+1; d < p.length && p1*p2*p3*p[d] <= n+k; d++){
                                        for(long p4 = p[d]; p1*p2*p3*p4 <= n+k; p4*=p[d]){
                                            arr[(int)(p1*p2*p3*p4)] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Out:
        for(int i = 4; i <= n; i++){
            for(int j = 0; j < k; j++) 
                if(!arr[i+j]) 
                    continue Out;
            System.out.println(i);
        }
    }
    int[] getPrimes(int n){
        HashSet<Integer> pr = new HashSet();
        boolean[] isP = new boolean[n+1];
        if(n >= 2) pr.add(2);
        for(int i = 2; i < isP.length; i+=2)isP[i] = true;
        int i = 3;
        while(i < isP.length){
            pr.add(i);
            for(int k = 2*i; k < isP.length; k += i) isP[k] = true;
            do{i+=2;}while(i < isP.length && isP[i]);
        }
        int[] p = new int[pr.size()];
        i = 0;
        for(int a : pr) p[i++] = a;
        Arrays.sort(p);
        return p;
    }
}