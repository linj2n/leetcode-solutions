// Approach #1 
// Runtime: 23 ms
class Solution {
    public String convertToPatternStr(String s) {
        HashMap <Character,Integer>sh = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int id = 0;
        for (char c: s.toCharArray()) {
            if (!sh.containsKey(c)) {
                sh.put(c,id); sb.append(id++);
            } else {
                sb.append(sh.get(c).intValue());
            }
        }
        return sb.toString();
    }
    public boolean isIsomorphic(String s, String t) {
        String str1 = convertToPatternStr(s);
        String str2 = convertToPatternStr(t);
        return str1.equals(str2);
    }
}