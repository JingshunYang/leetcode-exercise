/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (42.38%)
 * Likes:    258
 * Dislikes: 0
 * Total Accepted:    77.3K
 * Total Submissions: 182K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
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
// class Solution {
//     public int minDepth(TreeNode root) {
//         return helper(root, 0);
//     }

//     public int helper(TreeNode node, int depth) {
//         if (node == null) return 0;
//         if (node.left == null && node.right == null) {
//             return depth + 1;
//         }
//         int min;
//         int left_depth = helper(node.left, depth+ 1);
//         int right_depth = helper(node.right, depth + 1);
//         if (node.left == null) {
//             min = right_depth;
//         } else if (node.right == null) {
//             min = left_depth;
//         } else {
//             min = left_depth < right_depth ? left_depth : right_depth;
//         }
//         return min;
//     }
// }

class Solution {
    public int minDepth(TreeNode root) {
        Deque<Integer> depth_stack = new LinkedList<>();
        Deque<TreeNode> node_stack = new LinkedList<>();
        int min_depth = Integer.MAX_VALUE;
        if (root == null) return 0;
        depth_stack.push(1);
        node_stack.push(root);
        while(!node_stack.isEmpty()) {
            TreeNode node = node_stack.pop();
            int curr_depth = depth_stack.pop();
            if (node.left == null && node.right == null) {
                min_depth = Math.min(min_depth, curr_depth);
            } else {
                if (node.right != null) {
                    depth_stack.push(curr_depth + 1);
                    node_stack.push(node.right);
                }
                if (node.left != null) {
                    depth_stack.push(curr_depth + 1);
                    node_stack.push(node.left);
                }
            }
        }
        return min_depth;
    }
}
// @lc code=end

