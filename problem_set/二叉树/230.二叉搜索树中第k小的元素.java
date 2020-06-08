/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (70.51%)
 * Likes:    213
 * Dislikes: 0
 * Total Accepted:    53.5K
 * Total Submissions: 75.8K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 
 * 示例 1:
 * 
 * 输入: root = [3,1,4,null,2], k = 1
 * ⁠  3
 * ⁠ / \
 * ⁠1   4
 * ⁠ \
 * 2
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * ⁠      5
 * ⁠     / \
 * ⁠    3   6
 * ⁠   / \
 * ⁠  2   4
 * ⁠ /
 * ⁠1
 * 输出: 3
 * 
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrderTraversal(root, k, res);
        int target = res.get(k-1);
        return target;
    }

    public ArrayList<Integer> inOrderTraversal(TreeNode node, int k, ArrayList<Integer> res) {
        if (node == null) return res;
        inOrderTraversal(node.left, k, res);
        res.add(node.val);
        if (res.size() >= k) {
            return res;
        }
        inOrderTraversal(node.right, k, res);
        return res;
    }
}

/**
 * 思路中序遍历
 * 时间复杂度与中序遍历相同，即O(n)
 * 空间复杂度为O(h)，即平均情况为O(logn),最坏情况为O(n).
 */
// @lc code=end

