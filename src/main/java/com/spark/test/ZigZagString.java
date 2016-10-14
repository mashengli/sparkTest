package com.spark.test;

/**
 * @author mashengli
 */
public class ZigZagString {

    public static String convert(String s, int numRows) {
        if (s == null || s.equals("") || numRows <= 1) {
            return s;
        }
        String[] strs = new String[numRows];
        for (int i = 0; i< numRows; i++) {
            strs[i] = "";
        }
        int length = s.length();
        int sep = numRows;
        int len;
        for (int i = 0; i < s.length();) {
            len = (sep - 1) * 2;
            String temp;
            if (i + len > length) {
                temp = s.substring(i);
                len = temp.length();
            } else {
                temp = s.substring(i, i + len + 1);
            }
            if (temp.equals("")) {
                break;
            }
            for (int k = 0; k < len; k++) {
                if (k == 0) {
                    strs[k] = strs[k] + temp.charAt(0);
                    continue;
                }
                if (k == numRows - 1) {
                    if (len >= numRows) {
                        strs[k] = strs[k] + temp.charAt(numRows - 1);
                    }
                    continue;
                }
                if (len >= k + 1) {
                    strs[k] = strs[k] + temp.charAt(k);
                }
                if (len >= sep - k + 1) {
                    strs[k] = strs[k] + temp.charAt(2 *(numRows - k));
                }
            }
            i += len;
        }
        String result = null;
        for (String sb : strs) {
            result = result + sb;
        }
        return result;
    }

    public static int reverse(int x) {
        long result = 0;
        int tmp = Math.abs(x);
        while(tmp>0){
            result *= 10;
            result += tmp % 10;
            if(result > Integer.MAX_VALUE){
                return 0;
            }
            tmp /= 10;
        }
        return (int)(x>=0?result:-result);
    }

    public static void main(String[] args) {
//        System.out.println(convert("AKLSDFVJK", 4));
        System.out.println(reverse(-1287673898));
    }
}
