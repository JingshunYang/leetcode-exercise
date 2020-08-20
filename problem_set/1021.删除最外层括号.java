class Solution {
    public String removeOuterParentheses(String S) {
        int flag = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (curr == '(') {
                if (flag > 0) ans.append(curr);
                ++flag;
            } else {
                --flag;
                if (flag > 0) ans.append(curr);
            }
        }
        return ans.toString();
    }
}

