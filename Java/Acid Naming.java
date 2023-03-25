// https://www.hackerrank.com/contests/w36/challenges/acid-naming

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String acidNaming(String name) {
        return (name.endsWith("ic") ? (name.startsWith("hydro") ? "non-metal":"polyatomic"): "not an") + " acid";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.next();
            String result = acidNaming(acid_name);
            System.out.println(result);
        }
        in.close();
    }
}