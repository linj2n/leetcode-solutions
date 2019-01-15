package _290;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> charIndices = new HashMap<>();
        Map<String, Integer> strIndices = new HashMap<>();

        char[] patternChars = pattern.toCharArray();
        String[] strs = str.split(" ");

        if (patternChars.length != strs.length) {
            return false;
        }

        for (int i = 0; i < patternChars.length; i ++) {
            Integer charIndex = charIndices.get(patternChars[i]);
            Integer strIndex = strIndices.get(strs[i]);
            if (strIndex == null && charIndex == null) {
                charIndices.put(patternChars[i],i);
                strIndices.put(strs[i],i);
            } else if (strIndex == null || charIndex == null || !charIndex.equals(strIndex)) {
                return false;
            }
        }
        return true;
    }
}