// Approach #1 
class Solution {
    public boolean isHappy(int n) {
        HashSet hs = new HashSet();
        int sum = 0; 
        while (n != 1) {
            sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            if (hs.contains(sum)) return false;
            else hs.add(sum);
            n = sum;
        }
        return true;
    }
}