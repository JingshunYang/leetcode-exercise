class Solution {
    public int numTrees(int n) {
        // g[i] = sum(f[i])
        // f[i] = g[i-1] * g[n - i]

        int[] g = new int[n + 1];
        int[] f = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        int s = 2;
        while (s <= n) {
            int sum = 0;
            for (int i = 1; i <= s; i++) {
                f[i] = g[i - 1] * g[s - i];
                sum += f[i];
            }
            g[s++] = sum;
        }
        return g[n];
    }
}

