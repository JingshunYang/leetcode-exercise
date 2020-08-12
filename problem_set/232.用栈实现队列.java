/**
 * 解法1：
 */

class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    /** 时间复杂度：O(n) */
    public void push(int x) {
        while (s1.size() > 0) {
            int temp = s1.pop();
            s2.push(temp);
        }
        s1.push(x);
        while(s2.size() > 0) {
            int temp = s2.pop();
            s1.push(temp);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }   
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

class MyQueue {
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. 
     * 均摊时间复杂度O(1)
    */
    public int pop() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (s2.isEmpty()) {
            return front;
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * 解法2：
 */
class MyQueue {
    private int front;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. 
     * 时间复杂度O(1)
    */
    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s2.isEmpty()) {
            return front;
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
