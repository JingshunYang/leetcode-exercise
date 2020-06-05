/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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

class Status {
    public int targetNodesNum;
    public TreeNode ancestor;
    public Status(int targetNodesNum, TreeNode ancestor) {
        this.targetNodesNum = targetNodesNum;
        this.ancestor = ancestor;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCAHelper(root, p, q).ancestor;
    }
    public Status LCAHelper(TreeNode tree, TreeNode node1, TreeNode node2) {
        if (tree == null) return new Status(0, null);
        Status leftSubtree = LCAHelper(tree.left, node1, node2);
        if (leftSubtree.targetNodesNum == 2) {
            return leftSubtree;
        }
        Status rightSubtree = LCAHelper(tree.right, node1, node2);
        if (rightSubtree.targetNodesNum == 2) {
            return rightSubtree;
        }
        int targetNodesNum = leftSubtree.targetNodesNum + rightSubtree.targetNodesNum
            + (tree == node1 ? 1 : 0) + (tree == node2 ? 1 : 0);
        return new Status(targetNodesNum, targetNodesNum == 2 ? tree : null);
    }
}
// @lc code=end

