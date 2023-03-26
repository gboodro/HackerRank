// https://www.hackerrank.com/contests/projecteuler/challenges/euler035

import java.util.*;
import java.math.BigInteger;
class Solution{
    static HashSet<String> s;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] hit = new boolean[n];
        long sum = 0;
        for(int i = 2; i < n; i++){
            if(!hit[i]){
                if(isCirc(i+""))
                    for(String k : s){
                        int c = Integer.parseInt(k); 
                        if(c >= i && c < n)
                            sum += c;
                    }
                for(String k : s) hit[Integer.parseInt(k)] = true;                
            }
        }
        System.out.println(sum);
    }
    static boolean isCirc(String n){
        s = new HashSet();
        while(!s.contains(n) && new BigInteger(n).isProbablePrime(10)){
            s.add(n);
            n = n.substring(1) + n.charAt(0);
        }
        boolean r = s.contains(n);
        while(!s.contains(n)){
            s.add(n);
            n = n.substring(1) + n.charAt(0);
        }
        return r;
    }
}