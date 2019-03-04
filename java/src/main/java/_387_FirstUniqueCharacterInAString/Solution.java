package _387_FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqChar(String s) {
        return solution2(s);
    }
    private int solution1(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i ++) {
            Integer times = map.get(chars[i]);
            if (times == null) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], ++ times);
            }
        }
        for (int j = 0; j < chars.length; j ++){
            if (map.get(chars[j]).equals(1)) {
                return j;
            }
        }
        return -1;
    }
    private int solution2(String s) {
        int[] timesByChar = new int[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            timesByChar[chars[i]] ++;
        }
        for (int j = 0; j < chars.length; j ++) {
            if (timesByChar[chars[j]] == 1) {
                return j;
            }
        }
        return -1;
    }
}
