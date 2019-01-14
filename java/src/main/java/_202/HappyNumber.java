package _202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum, temp;
            for (sum = 0, temp = n; temp != 0; temp /= 10) {
                sum += Math.pow(temp % 10,2);
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}