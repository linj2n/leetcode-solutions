package _153_FindMinimumInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[0] > nums[r]) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < nums[0]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }
}
