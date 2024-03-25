package com.exam.test;

/**
 * @author guoly
 * @date 2024/3/25
 * @description
 */
public class Main {
    public static void main(String [] args) {
        // Stage 1:
        System.out.println("Stage 1:");
        String in = "aabcccbbad";
        while (true) {
            String res = defineIdenticalAndRemove(in);
            if (res.equals(in)) {
                break;
            }
            System.out.println(res);
            in = res;
        }

        // Stage 2:
        System.out.println("Stage 2:");
        in = "abcccbad";
        while (true) {
            String res = defineIdenticalAndReplacePrev(in);
            if (res.equals(in)) {
                break;
            }
            System.out.println(res);
            in = res;
        }
    }

    private static String defineIdenticalAndRemove(String str) {
        if (str.equals("") || str == null) {
            return "";
        }
        char temp = str.charAt(0);
        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            if (temp == str.charAt(i)) {
                continue;
            } else {
                int l = i - idx;
                if (l >= 3) {
                    String res = str.substring(0, idx) + str.substring(i);
                    return res;
                }
                temp = str.charAt(i);
                idx = i;
            }
        }
        return str;
    }

    private static String defineIdenticalAndReplacePrev(String str) {
        if (str.equals("") || str == null) {
            return "";
        }
        char temp = str.charAt(0);
        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            if (temp == str.charAt(i)) {
                continue;
            } else {
                int l = i - idx;
                if (l >= 3) {
                    String res;
                    if (idx == 0) {
                        res = str.substring(0, idx) + str.substring(i);
                    } else {
                        res = str.substring(0, idx) + str.charAt(idx - 1) + str.substring(i);
                    }
                    return res;
                }
                temp = str.charAt(i);
                idx = i;
            }
        }
        return str;
    }
}
