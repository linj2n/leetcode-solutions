package _81_SearchInRotatedSortedArrayII;

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r && nums[l] == nums[r]) {
            r --;
        }
        int rotatedK = 0;
        if (nums[l] > nums[r]) {
            int first = l, last = r;
            while (first < last) {
                mid = first + (last - first) / 2;
                if (nums[mid] < nums[0]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            }
            rotatedK = first;
        }
        return doSearch(nums, l, r, rotatedK, target);
    }
    private boolean doSearch(int[] nums, int l, int r, int rotatedK, int target) {
        int length = r - l + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int realMid = (mid + rotatedK) % length;
            if (nums[realMid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int res = (l + rotatedK) % length;
        if (nums[res] != target) {
            return false;
        }
        return true;
    }
}
