package _20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) return false;
        Map<Character,Character> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        for (Character c: s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addFirst(c);
            } else {
                Character needMatch = stack.pollFirst();
                if (needMatch == null || !map.get(needMatch).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}