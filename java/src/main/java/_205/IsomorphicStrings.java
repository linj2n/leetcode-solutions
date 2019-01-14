package _205;

import java.util.HashMap;

public class IsomorphicStrings{
    public boolean isIsomorphic(String s, String t) {
        return solution1(s, t);
    }

    // solution 1:
    private boolean solution1(String s, String t) {
        return s.length() == t.length() &&
                convertToPattern(s).equals(convertToPattern(t));
    }

    private String convertToPattern(String str) {
        int[] set = new int[256];
        int id = 1;
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (set[ch] == 0) {
                set[ch] = id ++;
            }
            sb.append(set[ch]);
        }
        return sb.toString();
    }

    private boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        int code1 = 1, code2 = 1;
        int[] set1 = new int[256];
        int[] set2 = new int[256];
        for (int i = 0; i < char1.length; i ++) {
            char digit1 = char1[i];
            char digit2 = char2[i];
            set1[digit1] = (set1[digit1] == 0) ? code1 ++ : set1[digit1];
            set2[digit2] = (set2[digit2] == 0) ? code2 ++ : set2[digit2];
            if (code1 != code2 || set1[digit1] != set2[digit2]) {
                return false;
            }
        }
        return true;
    }
}

