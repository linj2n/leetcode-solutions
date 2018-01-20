// Approach #1: Brute Force
// Runtime: 5 ms
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i] == B[j]) {
                    ans[i] = j; break;
                }
            }
        }
        return ans;
    }
}
// Approach #2: Use HashMap
// Runtime: 7 ms
import java.util.*;
class Solution {
        public int[] anagramMappings(int[] A, int[] B) {
            int[] ans = new int[A.length];
            Map <Integer, Integer> h = new HashMap<>();
            for (int i = 0; i < B.length; i++) {
                h.put(B[i],i);
            }
            for (int j = 0; j < A.length; j++) {
                ans[j] = h.get(A[j]);
            }
            return ans;      
        }
}
