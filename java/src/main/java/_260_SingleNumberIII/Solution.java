package _260_SingleNumberIII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] singleNumber(int[] nums) {
        return solution1(nums);
    }

    // Solution 1: Using Map
    // Time : O(n), Space: O(n)
    private int[] solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer times = map.get(i);
            map.put(i, times == null ? 1 : times + 1);
        }
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue().equals(1)) {
                res[i++] = e.getKey();
            }
        }
        return res;
    }

    // Solution 2: Bit Manipulation
    // Time : O(n), Space: O(1)
    private int[] solution2(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum ^= n;
        }
        int k = 0;
        while ((sum >> k & 1) == 0) {
            k++;
        }
        int first = 0;
        for (int e : nums) {
            if ((e >> k & 1) == 1) {
                first ^= e;
            }
        }
        return new int[]{first, sum ^ first};
    }
}