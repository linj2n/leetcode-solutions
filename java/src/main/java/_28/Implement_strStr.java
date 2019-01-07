package _28;

public class implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        int beginIndex = 0; 
        while ((haystack.length() - beginIndex) >= needle.length()) {
            int j = beginIndex, k = 0;
            while (k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                j ++; k++;
            }
            if (k == needle.length()) {
                return beginIndex;
            }
            beginIndex ++;
        }
        return -1;
    }   
}