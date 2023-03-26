// https://www.hackerrank.com/challenges/crush

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Fenwick t = new Fenwick(n);
        for(int i = 0; i < m; i++){
            int a = in.nextInt(), b = in.nextInt();
            long k = in.nextLong();
            t.update(a, b, k);
        }
        System.out.println(t.max());
    }
    
    private static class Fenwick {
        
        long[] dataMul, dataAdd;
        public Fenwick(int n){
            dataMul = new long[n+1];
            dataAdd = new long[n+1];
        }

        private void update(int left, int right, long by) {
            internalUpdate(left, by, -by * (left - 1));
            internalUpdate(right, -by, by * right);
        }
        
        private void print(){
            for(int i = 1; i < dataMul.length; i++) System.out.print(query(i)-query(i-1)+" ");
            System.out.println();
        }

        private void internalUpdate(int at, long mul, long add) {
            while (at < dataMul.length) {
                dataMul[at] += mul;
                dataAdd[at] += add;
                at |= (at + 1);
            }
        }

        private long query(int at) {
            long mul = 0;
            long add = 0;
            long start = at;
            while (at >= 0) {
                mul += dataMul[at];
                add += dataAdd[at];
                at = (at & (at + 1)) - 1;
            }
            return mul * start + add;
        }
        
        public long max(){
            long m = 0, pq = 0;
            for(int i = 1; i < dataMul.length; i++){
                long q = query(i);
                m = Math.max(m, q-pq);
                pq=q;
            }
            return m;
        }
    }
}