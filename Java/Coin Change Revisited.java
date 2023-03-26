// https://www.hackerrank.com/contests/segfault/challenges/coin-change-revisited

import java.util.Scanner;

class Solution{
   static int coin[] = {1,5,10,20,50};
   static int max_n=10000,N;
   static int [][]memo=new int[10][10000+5];
   static int coinChange(int index,int current_value)
   {
      if(current_value==0)return 1;
      if(current_value<0)return 0;
      if (index==5) return 0;
      if (memo[index][current_value]!=-1) return memo[index][current_value];
      int ans=coinChange(index,current_value - coin[index])+coinChange(index+1,current_value);
      ans=ans%10000000;
      memo[index][current_value]=ans;
      return ans;
   }

    public static void main(String []argh)
    {
      for(int j=0;j<7;j++)for(int k=0;k<10001;k++)memo[j][k]=-1;
        Scanner sc = new Scanner(System.in);
      int t;
      t=sc.nextInt();
      for(int i=0;i<t;i++)
      {
         N=sc.nextInt();
         System.out.println(coinChange(0,N));
         //for(int j=0;j<7;j++)for(int k=0;k<10001;k++)memo[j][k]=-1;
      }
    }
}
