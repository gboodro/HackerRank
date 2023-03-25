// https://www.hackerrank.com/contests/w36/challenges/revised-russian-roulette

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] revisedRussianRoulette(int[] doors) {
        int max = 0, min = 0;
        for(int i = 0; i < doors.length-1; i++){
            if(doors[i] == 1){
                max++;min++;
                if(doors[i+1] == 1){
                    max++;
                    doors[i+1] = 0;
                }
            }
        }
        if(doors[doors.length - 1] == 1){
            max++;min++;
        }
        return new int[] {min, max};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}