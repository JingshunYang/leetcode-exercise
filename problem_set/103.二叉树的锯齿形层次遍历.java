import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
        LinkedList<TreeNode> stack = new LinkedList<>();
        queue.add(root);
        int levelNum = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    currentLevel.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            if (currentLevel.size() > 0) {
                if (levelNum % 2 != 0) {
                    result.add(reverseList(currentLevel));
                } else {
                    result.add(currentLevel);
                }
            }
            levelNum++;
        }
        return result;
    }

    public LinkedList<Integer> reverseList(LinkedList<Integer> l) {
        LinkedList<Integer> r = new LinkedList<>();
        int len = l.size();
        for (int i = 0; i < len; i++) {
            r.push(l.poll());
        }
        return r;
    }
}
// @lc code=end

