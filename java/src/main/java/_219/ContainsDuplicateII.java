package _219;

import java.util.HashMap;
import java.util.Map;

// Approach #1
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i],i);
            }else {
                int j = hm.get(nums[i]).intValue();
                if (k >= i - j) return true;
                hm.put(nums[j],i);
            }
        }
        return false;
    }
}