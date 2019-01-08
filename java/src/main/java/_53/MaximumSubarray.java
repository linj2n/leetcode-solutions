package _53;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return solution2(nums, 0, nums.length - 1);
    }

    private int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; ++ i) {
            for (int sum = 0, j = i; j < nums.length; ++ j) {
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    private int solution2(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int center = left + (right - left) / 2;
        int maxLeftSum = solution2(nums,left,center);
        int maxRightSum = solution2(nums,center + 1, right);

        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        for (int i = center - 1, leftBorderSum = 0; i >= left; i--) {
            leftBorderSum += nums[i];
            maxLeftBorderSum = Math.max(maxLeftBorderSum,leftBorderSum);
        }

        for (int j = center + 1, rightBorderSum = 0; j <= right; j++) {
            rightBorderSum += nums[j];
            maxRightBorderSum = Math.max(maxRightBorderSum,rightBorderSum);
        }
        return Math.max(Math.max(maxLeftSum,maxRightSum),
                maxLeftBorderSum + maxRightBorderSum + nums[center]);
    }
}
