// Approach #1 
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        Set hs = new HashSet();
        for (int i: nums) {
            if (hs.contains(i)) return true;
            hs.add(i);
        }
        return false;
    }
}