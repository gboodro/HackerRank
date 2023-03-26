// https://www.hackerrank.com/contests/projecteuler/challenges/euler034

import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        long[] sumFact = new long[100001];
        for(int i = 1; i < sumFact.length; i++)sumFact[i] = fact[i%10] + sumFact[i/10];
        for(int i = 0; i < 10; i++)sumFact[i] = 0;
        for(int i = 10; i < sumFact.length; i++)sumFact[i] = sumFact[i-1] + (sumFact[i] % i == 0 ? i:0);
        Scanner in = new Scanner(System.in);
        System.out.println(sumFact[in.nextInt()]);
    }
}