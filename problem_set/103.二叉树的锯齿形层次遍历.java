import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (54.50%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    59.8K
 * Total Submissions: 109.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
        queue.add(root);
        int len;
        boolean reverseFLag = false;
        LinkedList<Integer> currentLevel;
        TreeNode current;
        while (!queue.isEmpty()) {
            len = queue.size();
            currentLevel = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (reverseFLag) {
                    currentLevel.push(current.val);
                } else {
                    currentLevel.add(current.val);
                }
            }
            result.add(currentLevel);
            reverseFLag = !reverseFLag;
        }
        return result;
    }
}
// @lc code=end

