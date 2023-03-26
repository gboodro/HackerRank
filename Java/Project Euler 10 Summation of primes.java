// https://www.hackerrank.com/contests/projecteuler/challenges/euler010

import java.io.*;
class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        long[] sum=sumP(1000001);
        for(;t-->0;)System.out.println(sum[Integer.parseInt(in.readLine())]);
    }
    static long[] sumP(int n){
        long[] sum=new long[n+1];
        sum[2]=2;
        for(int i=3;i<=n;i+=2)sum[i]=i;
        int j=3;
        while(j<=n){
            for(int k=j*2;k<=n;k+=j)sum[k]=0;
            do{j+=2;}while(j<=n&&sum[j]==0);
        }
        for(int i=3;i<=n;i++)sum[i]+=sum[i-1];
        return sum;
    }
}