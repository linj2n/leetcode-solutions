class Solution {
    
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(), 0, 0, k, n, ans);
        return ans;
    }
    
    private void dfs(List<Integer> path, int i, int sum, int k, int n, List<List<Integer>> ans) {
        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return ;
        } 
        if (path.size() > k || i == nums.length) {
            return ;
        }
        dfs(path, i + 1, sum, k, n, ans);
        path.add(nums[i]);
        dfs(path, i + 1, sum + nums[i], k, n, ans);
        path.remove(path.size() - 1);
    }
}
