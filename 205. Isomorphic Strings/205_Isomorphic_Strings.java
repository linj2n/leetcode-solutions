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

// Approach #2 
// Runtime: 6 ms
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() == 0) return true;
        
        int[] charValueOfS = new int[128];
        int[] charValueOfT = new int[128];
        boolean resFlag = true;
        
        int patternNumOfS = 1,patternNumOfT = 1,arrayLen = s.length();
        for (int i = 0; i < arrayLen; i++) {
            char currCharOfS = s.charAt(i);
            char currCharOfT = t.charAt(i);            
            if (charValueOfT[currCharOfT] != charValueOfS[currCharOfS]) {
                resFlag = false; break;
            } 
            charValueOfS[currCharOfS] = patternNumOfS++;
            charValueOfT[currCharOfT] = patternNumOfT++;
        }
        return resFlag;
    } 
}