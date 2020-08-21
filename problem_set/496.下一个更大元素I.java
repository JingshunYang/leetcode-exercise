class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int curr = nums2[i];
            while (!stack.isEmpty() && curr > stack.peek()) {
                int temp = stack.pop();
                map.put(temp, curr);
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            map.put(temp, -1);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
