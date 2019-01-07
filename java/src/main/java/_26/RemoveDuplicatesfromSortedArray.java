package _26;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lastIndex = 0;
        for (int walk = lastIndex; walk < nums.length; ++ walk) {
            if (nums[lastIndex] != nums[walk]) {
                nums[++ lastIndex] = nums[walk];   
            }
        }
        return lastIndex + 1;
    }
}
