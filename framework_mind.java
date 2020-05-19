/** 
*  数据结构基本操作
* 任何数据结构的基本操作都离不开遍历 + 访问，即增删改查
*/

// 1. 数组框架遍历

void traverse(int[] arr) {
  for (int i = 0; i < arr.length; i++) {
    // iterative visit arr[i]
  }
}

// 2. 列表遍历框架
class ListNode {
  int val;
  ListNode next;
}

// iterative visit
void traverse (ListNode head) {
  for (ListNode p; p !== null; p = p.next) {
    // visit p.val
  }
}

// reverse visit
void traverse (ListNode head) {
  // visit p.val
  traverse(head.next)
}

// 3. 2叉树遍历框架
class TreeNode {
  int val;
  TreeNode left, right;
}
void traverse(TreeNode root) {
  // visit root.val
  traverse(root.left)
  traverse(root.right)
}

// 4. N叉树遍历框架
class TreeNode {
  int val;
  TreeNode[] children;
}

void traverse(TreeNode root) {
  // visit root.val
  for (TreeNode child : root.children) {
    traverse(child)
  }
}
