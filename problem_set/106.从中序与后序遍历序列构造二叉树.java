import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeToInorderIdx.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, postorder.length, 0, inorder.length, nodeToInorderIdx);
    }

    public TreeNode buildTreeHelper(int[] postorder, int postorderStart, int postorderEnd, int inorderStart,
            int inorderEnd, Map<Integer, Integer> nodeToInorderIdx) {
        if (postorderStart >= postorderEnd || inorderStart >= inorderEnd) {
            return null;
        }
        int rootInorderIdx = nodeToInorderIdx.get(postorder[postorderEnd - 1]);
        int leftSubtreeSize = rootInorderIdx - inorderStart;
        TreeNode node = new TreeNode(postorder[postorderEnd - 1]);
        node.right = buildTreeHelper(postorder, postorderStart + leftSubtreeSize, postorderEnd - 1, rootInorderIdx + 1,
                inorderEnd, nodeToInorderIdx);
        node.left = buildTreeHelper(postorder, postorderStart, postorderStart + leftSubtreeSize, inorderStart,
                rootInorderIdx, nodeToInorderIdx);
        return node;
    }
}
// @lc code=end

