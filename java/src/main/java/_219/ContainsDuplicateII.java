package _219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    // solution 2: Using hash set
    public boolean solution2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++ i) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // solution 3: Brute force
    public boolean solution3(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++ i) {
            for (int j = i + 1; j < nums.length && j <= i + k; ++ j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}