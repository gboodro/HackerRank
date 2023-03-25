// https://www.hackerrank.com/contests/w22/challenges/polygon-making

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 1){
            System.out.println(2);
            System.exit(0);
        }
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        double sum = 0;
        int cuts = 0;
        LinkedList<Double> sticks = new LinkedList();
        for(int i : a){
            sticks.push((double)i);
            sum += i;
        }
        sum -= a[a.length-1];
        while(sum <= sticks.peekFirst()){
            cuts++;
            double longest = sticks.pop();
            sum += longest;
            int i = 0;
            double half = longest / 2;
            while(i < sticks.size() && half < sticks.get(i)){i++;}
            sticks.add(i, half);
            sticks.add(i, half);
            sum -= sticks.peekFirst();
        }
        System.out.println(cuts);
    }
}
