/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (59.62%)
 * Likes:    224
 * Dislikes: 0
 * Total Accepted:    48.4K
 * Total Submissions: 81.1K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> currPath = new LinkedList<>();
        dfs(root, res, currPath, sum);
        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> res, LinkedList<Integer> currPath, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        currPath.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList(currPath));
            return;
        }
        if (node.left != null) {
            dfs(node.left, res, currPath, sum);
            currPath.removeLast();
        }
        if (node.right != null) {
            dfs(node.right, res, currPath, sum);
            currPath.removeLast();
        }
    }
}
// @lc code=end

