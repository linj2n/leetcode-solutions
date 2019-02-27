package _34_FindFirstAndLastPositionOfElementInSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        return solution2(nums, target);
    }
    // 查找 >= target 所有数中位置下标最小的数
    // [mid + 1, r], [l, mid]
    private int[] solution1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        int first = l, last = l;
        for (int i = first + 1; i < nums.length && nums[i] == target; i ++) {
            last ++;
        }
        return new int[]{first, last};
    }
    // 查找 <= target 所有数中位置下标最大的数
    // [l, mid - 1], [mid, r]
    private int[] solution2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        int first = l, last = l;
        for (int i = last - 1; i >= 0 && nums[i] == target; i --) {
            first --;
        }
        return new int[] {first, last};
    }
}
