package _27;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int lastIndex = -1;
        for (int walk = lastIndex +1; walk < nums.length; walk++) {
            if (nums[walk] == val) {
                continue;
            }
            nums[++lastIndex] = nums[walk];
        }
        return lastIndex + 1;
    }
}
