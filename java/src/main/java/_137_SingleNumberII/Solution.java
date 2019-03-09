package _137_SingleNumberII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        return solution2(nums);
    }
    private int solution1(int[] nums) {
        Map<Integer, Integer> timesByValue = new HashMap<>();
        for (int n : nums) {
            Integer times = timesByValue.get(n);
            timesByValue.put(n, times == null ? 1 : times + 1);
        }
        for (Map.Entry<Integer, Integer> e : timesByValue.entrySet()) {
            if (e.getValue().equals(1)) {
                return e.getKey();
            }
        }
        return -1;
    }
    private int solution2(int[] nums) {
        int[] bits = new int[32];
        for (int n : nums) {
            int k = 0;
            for (int i = 0; i < bits.length; i ++) {
                if ((n >> k ++ & 1) == 1) {
                    bits[i] = (bits[i] + 1) % 3;
                }
            }
        }
        int res = 0;
        for (int k = 0; k < bits.length; k ++) {
            res = res | (bits[k] << k);
        }
        return res;
    }
}
