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
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hs = new int[52];
        for (int i = 0; i < s.length(); i++) {
            hs[s.charAt(i) - 'a'] ++;
            hs[t.charAt(i) - 'a' + 26] ++;
        }
        for (int j = 0; j < 26; j++) {
            if (hs[j] != hs[j + 26]) return false;
        }
        return true;
    }
}