package _28;

import java.util.StringBuilder;

public class CountAndSay {
    public String countAndSay(int n) {
        int i = 0;
        String str = "1";
        if (n == 1) {
            return str;
        }
        while (i < n - 1) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < str.length()) {
                int count = 0, k = j;
                while (k < str.length() && str.charAt(j) == str.charAt(k)) {
                    count ++;
                    k ++;
                }
                sb.append(String.valueOf(count)).append(str.charAt(j));
                j = k;
            }
            str = sb.toString();
            i ++;
        }
        return str;
    }
}