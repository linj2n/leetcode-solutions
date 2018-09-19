package _27;
public class RemoveElement {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lastIndex = 0;
        for (int walk = lastIndex + 1; walk < nums.length; walk ++) {
            if (walk < nums.length && nums[lastIndex] == nums[walk]) {
                continue;
            }
            nums[++ lastIndex] = nums[walk];
        }
        return lastIndex + 1;
    }
}
