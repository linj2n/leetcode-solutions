package _219;

import java.util.HashMap;
import java.util.Map;

// Approach #1
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return solution1(nums, k);
    }

    // solution 1: Using hash table
    private boolean solution1(int[] nums, int k) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; ++ i) {
            Integer index = indexByValue.get(nums[i]);
            if (index != null && (i - index <= k)) {
                return true;
            }
            indexByValue.put(nums[i],i);
        }
        return false;
    }
}