int removeElement(int* nums, int numsSize, int val) {
    if (numsSize == 0)
        return numsSize;
    int i = -1;
    int j = i + 1;
    while (j < numsSize)
    {
        if (nums[j] != val)
        {
            nums[++i] = nums[j];
        }
        j++;
    }
    return i + 1;
}