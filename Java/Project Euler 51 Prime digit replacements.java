// https://www.hackerrank.com/contests/projecteuler/challenges/euler051

import java.util.*;

public class Solution {
    
    boolean[] isPrime = erath(10000000);
    
    public static void main(String[] args) {
        new Solution();
    }
    
    Solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt(), L = in.nextInt();
        int a[] = new int[n];
        Arrays.fill(a, -1);
        while(count(a) != k || a[0] == 0) a = next(a);
        String min = "";
        int minV = 10000000;
        while(a.length == n){  
            if(getPrimes(a) >= L){
                String cur = getSet(a);
                int curV = Integer.parseInt(cur.split(" ")[0]);
                if(curV < minV){
                    minV = curV;
                    min = cur;
                }
            }
            do{
                a = next(a);
            }while(count(a) != k || a[0] == 0);
        }
        String[] spl = min.split(" ");
        for(int i = 0; i < L; i++)
            System.out.print(spl[i] + " ");        
    }
    
    int count(int[] a){
        int c = 0;
        for(int i:a) if(i==-1)c++;
        return c;
    }
    
    String getSet(int[] a){
        String res = "";
        if(a[0] != -1){
            int cur = replace(a, 0);
            if(isPrime[cur]) res += cur + " ";
        }
        for(int i = 1; i < 10; i++){
            int cur = replace(a, i);
            if(isPrime[cur]) res += cur + " ";
        }
        return res;
    }
    
    int replace(int[] a, int d){
        int c = 0;
        for(int i:a)c=c*10+(i==-1?d:i);
        return c;
    }
    
    private int getPrimes(int[] n){
        int count = 0;
        for(int i = 9; i > 0; i--)if(isPrime[replace(n, i)])count++;
        if(n[0] != -1 && isPrime[replace(n, 0)])
            count++;
        return count;
    }    
    
    private int[] next(int[] n){
        int t = 0;
        n[t] = (n[t] + 2) % 11 - 1;
        while(t < n.length-1 && n[t] == -1)
            n[++t] = (n[t] + 2) % 11 - 1;
        if(t == n.length-1)
            if(n[t] == 0)
                n[t]++;
            else if(n[t] == -1)
                return newNum(t+2);
        return n;
    }

    private int[] newNum(int t){
        int temp[] = new int[t];
        for(int i = 0; i < t; i++)
            temp[i] = -1;
        return temp;
    }
    
    boolean[] erath(int n){
        isPrime = new boolean[n+1];
        for(int i = 3; i <= n; i+=2)isPrime[i]=true;
        if(n>=2)isPrime[2] = true;
        int i = 3;
        while(i <= n){
            for(int j = 2*i; j <= n; j+=i)isPrime[j] = false;
            do{i+=2;}while(i <= n && !isPrime[i]);
        }
        return isPrime;
    }
}