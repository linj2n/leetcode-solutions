package _125;
class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        for (int left = 0, right = s.length() - 1; left < right; left ++,right --) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }
            if (left < right && Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            }
        } 
        return true;
    }
}