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