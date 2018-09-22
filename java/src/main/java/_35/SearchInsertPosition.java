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
    private int solution2(int[] nums, int target) {
        if (nums == null) return -1;
        int beg = 0, end = nums.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            } 
        }
        return beg;
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