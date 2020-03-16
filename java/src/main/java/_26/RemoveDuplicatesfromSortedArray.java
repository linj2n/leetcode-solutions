package _26;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (r == 0 || nums[r] != nums[r - 1]) {
                nums[l ++] = nums[r];
            }
            r ++;
        }
        return l;    }
}
