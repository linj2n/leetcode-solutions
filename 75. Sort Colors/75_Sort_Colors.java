class Solution {
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