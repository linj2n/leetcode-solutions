package _33_SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1, mid = 0;
        if (nums[0] > nums[nums.length - 1]) {
            while (l < r) {
                mid = l + (r - l) / 2;
                if (nums[mid] < nums[0]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        int k = l;
        l = 0; r = nums.length - 1;
        while (l < r) {
            mid = l + (r - l) / 2 ;
            int realMid = (mid + k) % nums.length;
            if (nums[realMid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int res = (l + k) % nums.length;
        if (nums[res] != target) {
            return -1;
        }
        return res;
    }
}
