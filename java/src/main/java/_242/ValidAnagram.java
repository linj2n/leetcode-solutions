package _242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        return solution1(s, t);
    }

    // solution 1: Using hash table
    private boolean solution1(String s, String t) {
        return s.length() == t.length() && countingCharacters(s).equals(countingCharacters(t));
    }

    private Map<Character,Integer> countingCharacters(String s) {
        Map<Character, Integer> charCounting = new HashMap<>();
        for (char c: s.toCharArray()) {
            Integer count = charCounting.get(c);
            charCounting.put(c, (count == null) ? 1 : count + 1);
        }
        return charCounting;
    }

    // solution 2: Using hash table[Optimal]
    public boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] countsChar = new int[512];
        for (int i = 0; i < sChars.length; i ++) {
            countsChar[sChars[i]] ++;
            countsChar[tChars[i] + 256] ++;
        }
        for (int j = 0; j < sChars.length; j ++) {
            if (countsChar[sChars[j]] != countsChar[sChars[j] + 256]) {
                return false;
            }
        }
        return true;
    }
    // solution 3: Sort
    private boolean solution3(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        String str1 = String.valueOf(charS);
        String str2 = String.valueOf(charT);
        return str1.equals(str2);
    }
}
