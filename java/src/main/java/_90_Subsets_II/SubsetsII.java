class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            ans.add(path);
            return ans;
        }
        Arrays.sort(nums);
        // dfs_1(path, 0, nums, ans);
        dfs_2(path, 0, nums, ans);
        return ans;    }
    
    private void dfs_1(List<Integer> list, int i, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }
        int k = i;
        while (k < nums.length && nums[k] == nums[i]) {
            ++ k;
        }
        dfs(list, k, nums, ans);
        for (int t = i; t < k; t ++) {
            list.add(nums[t]);
            dfs(list, k, nums, ans);
        }
        for (int s = 0; s < k - i; s ++) {
            list.remove(list.size() - 1);
        }
    }

    private void dfs_2(List<Integer> path, int u, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int i = u; i < nums.length; i ++) {
            if (i > u && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(path, i + 1, nums, ans);
            path.remove(path.size() - 1);
        }
    }

}
