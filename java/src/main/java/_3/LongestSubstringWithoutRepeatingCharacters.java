package _3;
import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        return solution1(s);
    }
    private int solution1(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength,j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
    private int solution2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c) + 1,i);
            }
            map.put(c,j++);
            maxLength = Math.max(maxLength,j - i);
        }
        return maxLength;
    }
    private int solution3(String s) {
        int[] set = new int[128];
        int maxLength = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            Boolean existed = (set[s.charAt(j)] == 1);
            if (!existed) {
                set[s.charAt(j++)] = 1;
                maxLength = Math.max(maxLength,j - i);
            } else {
                set[s.charAt(i++)] = 0;
            }
        }
        return maxLength;
    }
}