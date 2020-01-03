public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if (S == null) {
            return ans;
        }
        dfs(new StringBuilder(), 0, S, ans);
        return ans;
    }
    
    private void dfs(StringBuilder path, int i, String S, List<String> ans) {
        if (i == S.length()) {
            ans.add(path.toString());
            return ;
        }
        char currChar = S.charAt(i);
        if (Character.isDigit(currChar)) {
            path.append(S.charAt(i));
            dfs(path, i + 1, S, ans);
        } else {
            path.append(Character.toUpperCase(currChar));
            dfs(path, i + 1, S, ans);
            path.deleteCharAt(path.length() - 1);
            path.append(Character.toLowerCase(currChar));
            dfs(path, i + 1, S, ans);
        }
        path.deleteCharAt(path.length() - 1);
    }
}