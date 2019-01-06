package _14;
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        return solution1(strs);
    }
    private String solution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = "";
        String firstStr = strs[0];
        for (int k = 0; k < firstStr.length(); k ++) {
            char ch = firstStr.charAt(k);
            for (int i = 1; i < strs.length; i ++) {
                String str = strs[i];
                if (k >= str.length() || ch != str.charAt(k)) {
                    return res;
                }
            }
            res += ch;
        }
        return res;
    }

    private String solution2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            boolean isCommonPrefix = (strs[i].indexOf(prefix) == 0);
            while (!isCommonPrefix) {
                prefix = prefix.substring(0,prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
                isCommonPrefix = (strs[i].indexOf(prefix) == 0);
            }
        }
        return prefix;
    }
}