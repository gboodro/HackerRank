// https://www.hackerrank.com/contests/infinitum-sep14/challenges/sherlock-and-geometry

import java.util.*;
import java.math.*;
import java.awt.geom.*;
public class Solution {

    public static void main(String[] args) {
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            double xc = in.nextDouble(), yc = in.nextDouble(), r = in.nextDouble();
            double R = r*r;
            double x1 = in.nextDouble(), y1 = in.nextDouble();
            double x2 = in.nextDouble(), y2 = in.nextDouble();
            double x3 = in.nextDouble(), y3 = in.nextDouble();
            Line2D L1 = new Line2D.Double(x1, y1, x2, y2);
            Line2D L2 = new Line2D.Double(x1, y1, x3, y3);
            Line2D L3 = new Line2D.Double(x3, y3, x2, y2);
            if(L1.ptSegDist(xc, yc) <= r){
                if(distSqu(x1, y1, xc, yc) >= R || distSqu(x2, y2, xc, yc) >= R){
                    System.out.println("YES");
                    continue;
                }
            }
            if(L2.ptSegDist(xc, yc) <= r){
                if(distSqu(x1, y1, xc, yc) >= R || distSqu(x3, y3, xc, yc) >= R){
                    System.out.println("YES");
                    continue;
                }
            }
            if(L3.ptSegDist(xc, yc) <= r){
                if(distSqu(x3, y3, xc, yc) >= R || distSqu(x2, y2, xc, yc) >= R){
                    System.out.println("YES");
                    continue;
                }
            }
            System.out.println("NO");
        }
    }
    double distSqu(double x1, double y1, double x2, double y2){
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}