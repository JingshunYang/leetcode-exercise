/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start

/**
 * 解法1：暴力解法
 * 时间复杂度O(n^2)， 空间复杂度O(1)
 */

 class Solution {
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = 0; j < i; j++) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            int m = Math.min(max_left, max_right);
            int cur_diff = m - height[i];
            ans += cur_diff > 0 ? cur_diff : 0;
        }
        return ans;
    }
}

/**
 * 解法2：动态规划
 * 时间复杂度O(n), 空间复杂度O(n)
 */

 class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int ans = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        max_left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        max_right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int temp = Math.min(max_left[i - 1], max_right[i + 1]) - height[i];
            ans += temp > 0 ? temp : 0;
        }
        return ans;
    }
}

/**
 * 解法3：双指针解法
 * 时间复杂度O(n), 空间复杂度O(1)
 */
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int max_left = 0, max_right = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > max_left ) {
                    max_left = height[left];
                } else {
                    ans += max_left - height[left];
                }
                left++;
            } else {
                if (height[right] > max_right) {
                    max_right = height[right];
                } else {
                    ans += max_right - height[right];
                }
                right--;
            }
        }
        return  ans;
    }
}

 // @lc code=end

