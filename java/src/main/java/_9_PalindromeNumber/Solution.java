package _9_PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        return solution2(x);
    }
    private boolean solution1(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);    
        for (int i = 0,j = str.length() - 1; i < j; i ++, j --) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    private boolean solution2(int x) {
        if (x < 0) {
            return false;
        }
        int[] digit = new int[11];
        int i = 0;
        for (int temp = x; temp != 0; i ++,temp /= 10) {
            digit[i] = temp % 10;
        }
        for (int beg = 0, end = i - 1; beg < end; beg ++, end --) {
            if (digit[beg] != digit[end]) {
                return false;
            }
        }
        return true;
    }
}