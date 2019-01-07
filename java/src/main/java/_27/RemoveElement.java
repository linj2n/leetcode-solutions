package _27;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int endIndex = 0;
        for (int walk = endIndex; walk < nums.length; ++ walk) {
            if (nums[walk] != val) {
                nums[endIndex ++] = nums[walk];
            }
        }
        return endIndex;
    }
}
