package _136;

import java.util.HashMap;
import java.util.Map;

class SingleNumber {
    public int singleNumber(int[] nums) {
        return solution2(nums);
    }

    // solution 1: Bit manipulation[xor]
    private int solution1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    // solution 2: Using HashTable
    private int solution2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            map.put(num,(count == null) ? 1 : count + 1);
        }
    
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}