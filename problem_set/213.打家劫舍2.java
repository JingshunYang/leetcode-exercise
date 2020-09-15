class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] res1 = helper(0, n - 2, nums);
        int[] res2 = helper(1, n - 1, nums);
        int temp1 = Math.max(res1[0], res1[1]);
        int temp2 = Math.max(res2[0], res2[1]);
        return Math.max(temp1, temp2);
    }

    private int[] helper(int start, int end, int[] nums) {
        if (start > end) return new int[]{0, 0};
        int[] res = helper(start + 1, end, nums);
        int f = nums[start] + res[1];
        int g = Math.max(res[0], res[1]);
        return new int[]{f, g};
    }
}
