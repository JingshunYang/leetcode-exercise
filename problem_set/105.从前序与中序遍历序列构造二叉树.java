import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * hint：根据前序遍历的第一个元素找到根元素，而中序遍历顺序和根元素又决定了左右子树的范围
 * 
 * Definition for a binary tree
 * node. public class TreeNode { int val; TreeNode left; TreeNode right;
 * TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeToInorderIdx.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, 0, preorder.length,
            nodeToInorderIdx);
    }
    public TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd, 
            int inorderStart, int inorderEnd, Map<Integer, Integer> nodeToInorderIdx) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }
        int rootInorderIdx = nodeToInorderIdx.get(preorder[preorderStart]);
        int leftSubtreeSize = rootInorderIdx - inorderStart;
        TreeNode node = new TreeNode(preorder[preorderStart]);
        node.left = buildTreeHelper(preorder, preorderStart + 1, 
            preorderStart + 1 + leftSubtreeSize, inorderStart, rootInorderIdx,
            nodeToInorderIdx);
        node.right = buildTreeHelper(preorder, preorderStart + 1 + leftSubtreeSize,
            preorderEnd, rootInorderIdx + 1, inorderEnd, nodeToInorderIdx);
        return node;
    }
}
// @lc code=end

