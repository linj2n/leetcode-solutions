class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        int sum = numbers[i] + numbers[j];
        while (sum != target) {
            if (sum > target) j--;
            else i ++;
            sum = numbers[i] + numbers[j];
        }
        res[0] = i + 1; res[1] = j + 1;
        return res;
    }
}