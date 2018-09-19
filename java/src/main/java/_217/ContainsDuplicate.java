package _217;

import java.util.HashSet;
import java.util.Set;

// Approach #1
// 13ms
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int e: nums) {
            if (!set.add(e)) {
                return true;
            }
        }
        return false;
    }
}

// Approach #2
// 6ms
//import java.util.*;
//class Solution {
//    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i+1]) return true;
//        }
//        return false;
//    }
//}