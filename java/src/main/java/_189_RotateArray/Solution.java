package _189_RotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        solution1(nums, k);
    }
    private void solution1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; ++ i) {
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp,0,nums,0,nums.length);
    }
    private void solution2(int[] nums, int k) {
        k = k % nums.length;
        for (int start = 0, count = 0; count < nums.length; start ++) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count ++;
            } while (start != current);
        }
    }
}
