// https://www.hackerrank.com/contests/101mar14/challenges/rectangular-game

import java.util.*;
class Solution{
  	public static void main(String[] args){
      	Scanner in = new Scanner(System.in);
      	int n = in.nextInt();
      	long minX = 1000000, minY = 1000000;
      	for(int i = 0; i < n; i++){
          	minX = Math.min(minX, in.nextInt());
          	minY = Math.min(minY, in.nextInt());
        }
      	System.out.print(minX*minY);
    }
  
}