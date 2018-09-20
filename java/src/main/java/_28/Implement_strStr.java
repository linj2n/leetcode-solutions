package _28;

public class implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        int i = 0; 
        while (i < haystack.length()) {
            int j = i, k = 0;
            while (k < needle.length() && j < haystack.length() && haystack.charAt(j) == needle.charAt(k)) {
                k ++;
                j ++;
            }
            if (k == needle.length()) {
                return i;
            }
            if (j == haystack.length()) {
                return -1;
            }            
            i ++;
        }
        return (i >= haystack.length()) ? -1 : i;
    }
}