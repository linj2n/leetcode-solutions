package _493_ReversePairs;

import java.util.Arrays;

public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return merge(nums, 0, nums.length - 1);
    }
    private int merge(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int count = 0, mid = l + (r - l) / 2;
        count += merge(nums, l, mid);
        count += merge(nums, mid + 1, r);
        int[] left = Arrays.copyOfRange(nums, l, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid + 1, r + 1);
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > 2 * (long)right[j]) {
                count += (left.length - i);
                j ++;
            } else {
                i ++;
            }
        }
        // starting to merge
        i = 0; j = 0;
        while (i < left.length && j < right.length) {
            if (right[j] < left[i]) {
                nums[l ++] = right[j ++];
            } else {
                nums[l ++] = left[i ++];
            }
        }
        while (i < left.length) {
            nums[l ++] = left[i ++];
        }
        while (j < right.length) {
            nums[l ++] = right[j ++];
        }
        return count;
    }
}

