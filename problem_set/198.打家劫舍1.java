class Solution {
  public int rob(int[] nums) {
    int[] res = helper(0, nums);
    return Math.max(res[0], res[1]);
  }

  private int[] helper(int index, int[] nums) {
    if (index >= nums.length)
      return new int[] { 0, 0 };
    int[] res = helper(index + 1, nums);
    int f = nums[index] + res[1];
    int g = Math.max(res[0], res[1]);
    return new int[] { f, g };
  }
}