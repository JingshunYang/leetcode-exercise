import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmpNode = root.right;
        root.right = root.left;
        root.left = tmpNode;
        helper(root.left);
        helper(root.right);
    }
}
// @lc code=end

