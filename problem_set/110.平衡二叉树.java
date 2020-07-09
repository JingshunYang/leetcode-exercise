/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (51.70%)
 * Likes:    323
 * Dislikes: 0
 * Total Accepted:    77.5K
 * Total Submissions: 149.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * 返回 false 。
 * 
 * 
 * 
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

class BalanceStatusWithHeight {
  public boolean isBalanced;
  public int height;
  public BalanceStatusWithHeight(boolean isBalanced, int height) {
    this.isBalanced = isBalanced;
    this.height = height;
  }
}
class Solution {
  public boolean isBalanced(TreeNode root) {
    return checkBalanced(root).isBalanced;
  }

  public BalanceStatusWithHeight checkBalanced(TreeNode node) {
    if (node == null) return new BalanceStatusWithHeight(true, -1);
    BalanceStatusWithHeight leftBalance = checkBalanced(node.left);
    if (!leftBalance.isBalanced) {
      return leftBalance;
    }
    BalanceStatusWithHeight rightBalance = checkBalanced(node.right);
    if (!rightBalance.isBalanced) {
      return rightBalance;
    }
    boolean isBalanced = Math.abs(leftBalance.height - rightBalance.height) <= 1;
    int height = Math.max(leftBalance.height, rightBalance.height) + 1;
    return new BalanceStatusWithHeight(isBalanced, height);
  }
}
// @lc code=end

