// https://www.hackerrank.com/challenges/insertionsort1

/* Head ends here */
import java.util.*;
public class Solution {
       
          static void insertionSort(int[] ar) {
              int v = ar[ar.length-1];
              int i = ar.length-2;
              while(i >= 0 && v < ar[i]){
                  if(v < ar[i]){
                      ar[i+1] = ar[i];
                  }else{
                      ar[i+1] = v;
                  }
                  print(ar);
                  i--;
              }
              ar[i+1] = v;
              print(ar);
       }   
    private static void print(int[] a){
        for(int i = 0; i < a.length; i++) System.out.print(a[i]+" ");
        System.out.println();
    }

/* Tail starts here */
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           insertionSort(ar);
       }    
   }
