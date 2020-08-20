class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < ops.length; i++ ) {
            String op = ops[i];
            if (op.equals("+")) {
                int top = stack.pop();
                int new_top = top + stack.peek();
                stack.push(top);
                stack.push(new_top);
                ans += new_top;
            } else if (op.equals("D")) {
                int temp = 2 * stack.peek();
                stack.push(temp);
                ans += temp;
            } else if (op.equals("C")) {
                ans -= stack.peek();
                stack.pop();
            } else {
                ans += Integer.valueOf(op);
                stack.push(Integer.valueOf(op));
            }
        }
        return ans;
    }
}
