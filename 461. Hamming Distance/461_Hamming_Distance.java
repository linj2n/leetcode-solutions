class Solution {
    public int hammingDistance(int x, int y) {
        int xorRes = x ^ y;
        int count = 0;
        while (xorRes != 0) {
            xorRes = xorRes & (xorRes - 1);
            count ++;
        }
        return count;
    }
}