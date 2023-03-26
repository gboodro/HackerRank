// https://www.hackerrank.com/contests/projecteuler/challenges/euler037

import java.util.*;
class Solution{
    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = {23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397};
        long s = 0L;
        for(int i : a) if(i < n)
            s += i;
        System.out.println(s);
    }
}