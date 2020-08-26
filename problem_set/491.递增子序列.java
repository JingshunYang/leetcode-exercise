class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }
    public void dfs(int curr, int last, int[] nums) {
        if (curr == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[curr] >= last) {
            temp.add(nums[curr]);
            dfs(curr + 1, nums[curr], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curr] != last) {
            dfs(curr + 1, last, nums);
        }
    }
}
