package _35;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return solution2(nums, target);
    }

    // 查找所有 >= target 最小的一个数的下标，即查找 target 的下标或 target 后继的下标
    // [mid + 1, r], [l, mid]
    private int solution1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[nums.length - 1] < target) {
            return l + 1;
        }
        return l;
    }

    // 插入所有 <= target 数中最大的一个数的下标， 即查找 target 的下标或 target 前驱的下标
    // [l, mid - 1], [mid, r]
    private int solution2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
