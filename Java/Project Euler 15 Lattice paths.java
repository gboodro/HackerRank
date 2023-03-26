// https://www.hackerrank.com/contests/projecteuler/challenges/euler015

import java.util.Scanner;
class Solution{
    static long[][] g = new long[501][501];
    static long m = 1000000007L;
    public static void main(String[] args){
        g[0][0] = 1;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;)System.out.println(go(in.nextInt(), in.nextInt()));
    }
    static long go(int x, int y){
        try{
            if(g[x][y] == 0)
                g[x][y] = (go(x-1,y) + go(x,y-1)) % m;
        }catch(ArrayIndexOutOfBoundsException e){
            return 0;
        }
        return g[x][y];
    }
}