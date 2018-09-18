import java.lang.Math;
import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] > height[j]) {
                res = Math.max(height[j] * (j - i),res); j--;
            } else {
                res = Math.max(height[i] * (j - i),res); i++;
            }
        }
        return res;
    }
}
