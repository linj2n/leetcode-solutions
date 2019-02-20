package _35;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return solution2(nums, target);
    }

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
        if (nums[l] >= target) {
            return l;
        }
        return l + 1;
    }

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
        if (nums[l] >= target) {
            return l;
        }
        return l + 1;
    }
}
