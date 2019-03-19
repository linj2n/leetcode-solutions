package _1012_ComplementofBase10Integer;

public class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int temp = N, nums = 0;
        while (temp != 0) {
            temp >>= 1;
            nums ++;
        }
        int mask = 1 << (nums - 1);
        while (mask != 0) {
            N ^= mask;
            mask >>=1;
        }
        return N;
    }
}
