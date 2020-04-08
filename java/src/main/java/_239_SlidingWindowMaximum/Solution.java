class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return solve2(nums, k);
    }
    private int[] solve2(int[] nums, int k) {
        int[] deque = new int[nums.length + 1];
        int[] ans = new int[nums.length + 1];
        int hh = 0, tt = -1, j = 0;
        for (int i = 0; i < nums.length; i ++) {
            while (hh <= tt && i - deque[hh] + 1 > k) {
                hh ++;
            }
            while (hh <= tt && nums[deque[tt]] <= nums[i]) {
                tt --;
            }
            deque[++ tt] = i;
            if (i + 1 >= k) {
                ans[j ++] = nums[deque[hh]];
            }
        }
        return Arrays.copyOf(ans, j);
        
    }
    private int[] solve1(int[] nums, int k) {
        int[] ans = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return null;
        }
        Deque<Integer> deque = new ArrayDeque<>(nums.length);
        int j = 0;
        for (int i = 0; i < nums.length; i ++) {
            while (!deque.isEmpty() && i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i + 1 >= k) {
                ans[j ++] = nums[deque.getFirst()];
            }
        }
        return Arrays.copyOf(ans, j);   
    }
}