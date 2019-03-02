package _154_FindMinimumInRotatedSortedArrayII;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r && nums[l] == nums[r]) {
            r --;
        }
        if (l < r && nums[l] > nums[r]) {
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
