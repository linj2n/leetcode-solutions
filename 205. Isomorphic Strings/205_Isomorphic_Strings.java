// Approach #1 
// Runtime: 23 ms
class Solution1 {
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

// Approach #1 
// Runtime: 13 ms
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length() ) return false;
        else if(s.length() == 0) return true;
        
        int[] charValueOfS = new int[128];
        int[] charValueOfT = new int[128];
        boolean resFlag = true;
        
        int[] patternArrayOfS = new int[s.length()];
        int[] patternArrayOfT = new int[t.length()];
        int patternNumOfS = 1,patternNumOfT = 1,arrayLen = s.length();
        for (int i = 0; i < arrayLen; i++) {
            char currCharOfS = s.charAt(i);
            char currCharOfT = t.charAt(i);
            if (charValueOfS[currCharOfS] == 0) {
                charValueOfS[currCharOfS] = patternNumOfS++;
            } 
            patternArrayOfS[i] = charValueOfS[currCharOfS];
            
            if (charValueOfT[currCharOfT] == 0) {
                charValueOfT[currCharOfT] = patternNumOfT++;
            } 
            patternArrayOfT[i] = charValueOfT[currCharOfT];
            if (patternArrayOfS[i] != patternArrayOfT[i]) {
                resFlag = false; break;
            } 
        }
        return resFlag;
    } 
}