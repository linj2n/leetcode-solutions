package _3;
import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        return solution1(s);
    }
    private int solution1(String s) {
        int[] set = new int[128];
        int ans = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            set[s.charAt(j)] ++;
            // 刚刚加入的元素出现了两次及其以上
            while (i < j && set[s.charAt(j)] > 1) {
                set[s.charAt(i)] --;
                i ++;
            }
            ans = Math.max(j - i + 1, ans);
            j ++;
        }
        return ans;
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