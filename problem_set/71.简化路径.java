/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!str[i].equals("") && !str[i].equals(".")) {
                stack.push(str[i]);
            }
        }
        int size = stack.size();
        if (size == 0)
            return "/";
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
}
// @lc code=end

