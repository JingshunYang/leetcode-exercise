/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        int min = min_stack.peek();
        min_stack.push(Math.min(min, x));
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

