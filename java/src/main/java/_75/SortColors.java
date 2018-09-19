package _75;

// Approach #1 Brute Force
public class SortColors {
    public void sortColors(int[] nums) {
        int size = nums.length;
        long r = 0,w = 0,b = 0;
        for (int i = 0; i < size; i++)
        {
            if (nums[i] == 0) r++;
            else if (nums[i] == 1) w++;
            else b++;
        }
        int i = -1;
        while(r != 0)
        {
            nums[++i] = 0;
            r--;
        }
        while(w != 0)
        {
            nums[++i] = 1;
            w--;
        }
        while(b != 0)
        {
            nums[++i] = 2;
            b--;
        }
    }
}
//// Approach #2 Use 3-way partition
//class Solution {
//    public void exch(int[] nums, int i, int j)
//    {
//        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
//    }
//    public void sortColors(int[] nums){
//        int r = 0, w = 0, b = nums.length - 1;
//        while (w <= b)
//        {
//            if (nums[w] == 0) exch(nums,w++,r++);
//            else if(nums[w] == 2) exch(nums,w,b--);
//            else if (nums[w] == 1) w++;
//        }
//    }
//}