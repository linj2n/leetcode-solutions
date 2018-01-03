int removeDuplicates(int* nums, int numsSize) {
    if (numsSize == 0)
        return numsSize;
    int i = 0;
    int j = i + 1;
    while (j < numsSize)
    {
        if (nums[i] != nums[j])
        {
            nums[++ i] = nums[j];
        }
        j++;
    }
    return i + 1;
}