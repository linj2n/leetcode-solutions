package _33_SearchInRotatedSortedArray;

public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1, delta = 0, mid = 0;
        if (nums[0] > nums[nums.length - 1]) {
            // find the pivot
            int firstElem = nums[0];
            while (l < r) {
                mid = l + (r - l) / 2;
                if (nums[mid] < firstElem) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            // update delta with pivot;
            delta = l;
        }
        // find the smallest element in the list that is larger than or equal to the given target with Delta.
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[(mid + delta) % nums.length] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return target == nums[(l + delta) % nums.length] ? (l + delta) % nums.length : - 1;
    }
}