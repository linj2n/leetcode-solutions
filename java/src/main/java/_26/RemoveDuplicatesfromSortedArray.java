package _26;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int endIndex = 0;
        for (int walk = endIndex; walk < nums.length; ++ walk) {
            if (nums[endIndex] != nums[walk]) {
                nums[++ endIndex] = nums[walk];   
            }
        }
        return endIndex + 1;
    }
}
