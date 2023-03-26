// https://www.hackerrank.com/challenges/stat-warmup

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double sum = 0.0;
        int[] a = new int[n];
        int[] count = new int[100001];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            sum += a[i];
            count[a[i]]++;
        }
        double mean = sum/n;
        System.out.println(round(mean));
        Arrays.sort(a);
        System.out.println(n % 2 == 0 ? round((a[n/2-1] + a[n/2])/2.0) : a[n/2]);
        int mode = -1, modeCount = -1;
        for(int i:a){
            if(count[i] > modeCount){
                mode = i;
                modeCount = count[i];
            }else if(count[i] == modeCount && i < mode) mode = i;
        }
        System.out.println(mode);
        double sqrSum = 0.0;
        for(int i : a) sqrSum += Math.pow(i-mean, 2);
        double stdDev = Math.sqrt(sqrSum/n);
        System.out.println(round(stdDev));
        System.out.println(round(mean - 1.96*stdDev/Math.sqrt(n)) + " " + round(mean + 1.96*stdDev/Math.sqrt(n)));
    }
    static double round(double n){
        return (int)(n*10)/10.0;
    }
}