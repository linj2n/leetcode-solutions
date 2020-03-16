package _80_RemoveDuplicatesFromSortedArrayII;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length ;
        }
        int l = 1, r = 2;
        while (r < nums.length) {
            if (nums[r] != nums[l - 1]) {
                nums[++ l] = nums[r];
            }
            r ++;
        }
        return l + 1;
    }
}