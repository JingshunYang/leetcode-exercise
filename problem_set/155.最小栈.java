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
 * 解法2：变量标记最小值
 */

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        if (min >= x) {
            s.push(min);
            min = x;
        }
        s.push(x);
    }

    public void pop() {
        int temp = s.pop();
        if (temp == min) {
            min = s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

