package _28;

public class implement_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        } 
        if (needle.length() == 0) {
            return 0;
        }
        int beginIndex = 0; 
        int hayLen = haystack.length(), needleLen = needle.length();
        while ((hayLen - beginIndex) >= needleLen) {
            int j = beginIndex, k = 0;
            while (k < needleLen && haystack.charAt(j) == needle.charAt(k)) {
                j ++; k++;
            }
            if (k == needleLen) {
                return beginIndex;
            }
            beginIndex ++;
        }
        return -1;
    }
}