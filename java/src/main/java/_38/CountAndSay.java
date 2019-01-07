package _28;

import java.util.StringBuilder;

public class CountAndSay {
    public String countAndSay(int n) {
        return solution1(n);
    }
    priavte String solution1(int n) {
        int i = 0;
        String str = "1";
        while (i < n - 1) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < str.length()) {
                int count = 0, k = j;
                while (k < str.length() && str.charAt(j) == str.charAt(k)) {
                    count ++;
                    k ++;
                }
                sb.append(count).append(str.charAt(j));
                j = k;
            }
            str = sb.toString();
            i ++;
        }
        return str;
    }

    private String solution2(int n) {
        String res = "1";
        for (int i = 1; i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            int k = 0, say = Character.digit(res.charAt(k),10), count = 0;
            while (k < res.length()) {
                int digit = Character.digit(res.charAt(k),10);
                if (digit == say) {
                    ++ count;
                } else {
                    sb.append(count).append(say);
                    say = digit;
                    count = 1;
                }
                ++ k;
            }
            sb.append(count).append(say);
            res = sb.toString();
        }
        return res;
    }
}