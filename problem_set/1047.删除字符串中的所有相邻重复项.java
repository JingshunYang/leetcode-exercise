class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int b_len = 0;
        for (char curr : S.toCharArray()) {
            if (b_len == 0 || curr != sb.charAt(b_len - 1)) {
                sb.append(curr);
                b_len++;
            } else {
                sb.deleteCharAt(b_len-- - 1);
            }
        }
        return sb.toString();
    }
}

