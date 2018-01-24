// Approach #1
// Runtime: 6 ms
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS); Arrays.sort(charT);
        String str1 = String.valueOf(charS); String str2 = String.valueOf(charT);
        return str1.equals(str2);
    }
}

// Approach #2
// Runtime: 