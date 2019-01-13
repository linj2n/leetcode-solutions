package _283;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
    }

    // solution 1: Two pointers
    private void solution1(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j ++;
            }
            if (i < nums.length && j < nums.length) {
                nums[i ++] = nums[j ++];
            }
        }
        while (i < nums.length) {
            nums[i ++] = 0;
        }
    }

    // solution 2: Two pointers [Code structure optimal]
    private void solution2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = lastNonZeroFoundAt; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt ++] = nums[i];
            }
        }

        for (int j = lastNonZeroFoundAt; j < nums.length; j ++) {
            nums[j] = 0;
        }
    }

    // solution 3: Swap
    private void solution3(int[] nums) {
        for (int lastNonZeroFoundAt = 0, i = 0, temp; i < nums.length; i ++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt ++] = temp;
            }
        }
    }
}
