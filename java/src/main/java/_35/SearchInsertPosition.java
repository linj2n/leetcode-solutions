package _35;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        return solution3(nums,target);
    }
    private int solution1(int[] nums, int target) {
        int i = 0; 
        for (; i < nums.length && target > nums[i]; i ++) {}
        return i; 
    }
    // bug free edition
    private int solution2(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first < last) {
            int mid = first + (last - first) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        return first;
    }
    private int solution3(int[] nums, int target) {
        if (nums == null) return -1;
        int beg = 0, end = nums.length - 1;
        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] < target) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }
        return (target > nums[beg]) ? beg + 1 : beg; 
    }}