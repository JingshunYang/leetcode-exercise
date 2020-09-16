/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private int index;
    private List<Integer> sortednodes;

    public BSTIterator(TreeNode root) {
        this.sortednodes = new ArrayList<>();
        this.index = -1;
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {
        if (root == null) return;
        this._inorder(root.left);
        this.sortednodes.add(root.val);
        this._inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.sortednodes.get(++this.index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.sortednodes.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

