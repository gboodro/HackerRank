// https://www.hackerrank.com/challenges/the-indian-job

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static HashSet<String> calc;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      	int t = in.nextInt();
      	for(int i = 0; i < t; i++){
          	int n = in.nextInt(), g = in.nextInt();
          	int[] a = new int[n];
          	for(int j = 0; j < n; j++)a[j]=in.nextInt();
          	calc = new HashSet();
          	System.out.println(free(a, 0, g, g) ? "YES":"NO");
        }
    }
  	
  	private static boolean free(int[] a, int i, int x, int y){
    	if(calc.contains(i + " " + x + " " + y) || calc.contains(i + " " + y + " " + x)) return false;
      	calc.add(i + " " + x + " " + y);
      	if(a.length == i) return true;
      	else if(x - a[i] >= 0 && free(a, i+1, x-a[i], y)) return true;
        else if(y - a[i] >= 0 && free(a, i+1, x, y-a[i])) return true;
        else return false;
    }
}