class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(), 0, nums, ans);
        return ans;
    }
    
    private void dfs(List<Integer> list, int i, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        int k = i;
        while (k < nums.length && nums[k] == nums[i]) {
            ++ k;
        }
        for (int t = i; t < k; t ++) {
            dfs(list, t + 1, nums, ans);
            list.add(nums[t]);
        }
        for (int s = 0; s < k - i + 1; s ++) {
            list.remove(list.size() - 1);
        }
    }
}
