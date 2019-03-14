package _215_KthLargestElementInAnArray;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }   
        int lo = 0, hi = nums.length - 1;
        k --;
        while (lo < hi) {
            int i = lo, j = hi, pivot = nums[lo];
            while (i < j) {
                while (i < j && nums[j] <= pivot) {
                    j --;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] >= pivot) {
                    i ++;
                }
                nums[j] = nums[i];
            }
            nums[i] = pivot;
            if (i == k) {
                break;
            }
            if (i > k) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }
        return nums[k];
    }
}
