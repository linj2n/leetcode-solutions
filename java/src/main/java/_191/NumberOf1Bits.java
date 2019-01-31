package _191;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0, mask = 1;
        for (int i = 0; i < 32; i ++) {
            if ((mask & n) != 0) {
                bits ++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
