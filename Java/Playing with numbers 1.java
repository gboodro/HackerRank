// https://www.hackerrank.com/contests/magic-lines-september-2015/challenges/playing-with-numbers-magic-lines

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution {   
   BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
   public void solve() throws IOException {            
      int N = nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = nextLong();
        }
        Arrays.sort(A);
        long[] cumA = new long[N];
        cumA[0] = A[0];
        for (int i = 1; i < N; i++) {
            cumA[i] = cumA[i-1] + A[i];
        }

      int Q = nextInt();
        long sumY = 0;
        for (int q = 0; q < Q; q++) {
            sumY += nextLong();
            int l = 0;
            int r = N-1;
            while (l < r) {
                int m = (l + r) / 2;
                if (A[m] + sumY < 0) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (A[l] + sumY < 0) l++;

            long ans = 0;
            if (l > 0) {
                ans += -1 * (cumA[l-1] + sumY * (l));
            }
            if (l <= N-1) {
                ans += (cumA[N-1] - cumA[l] + A[l] + sumY * (N - l));
            }
            out.println(ans);
        }
   }
   
   /**
    * @param args
    */
   public static void main(String[] args) {
      new Solution().run();
   }
   
   public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
