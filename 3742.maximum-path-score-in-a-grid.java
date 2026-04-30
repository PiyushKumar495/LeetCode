class Solution {
    int m, n;
    int solver(int i, int j, int cost, int[][] grid, int k, int[][][] dp) {
        if (i >= m || j >= n) return (int) -1e9;

        int addCost = (grid[i][j] == 0) ? 0 : 1;
        int score = grid[i][j];

        if (cost + addCost > k) return (int) -1e9;
        if (i == m - 1 && j == n - 1) return grid[i][j];

        if (dp[i][j][cost + addCost] != -1) return dp[i][j][cost + addCost];

        int best = Math.max(solver(i + 1, j, cost + addCost, grid, k, dp), solver(i, j + 1, cost + addCost, grid, k, dp));

        return dp[i][j][cost + addCost] = (best == (int) -1e9) ? (int) -1e9 : best + score;
    }


    public int maxPathScore(int[][] grid, int k) {
        m = grid.length; n = grid[0].length;

        int[][][] dp = new int[m + 1][n + 1][k + 1];

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                for (int c = 0; c <= k; c++)
                    dp[i][j][c] = -1;


        int res = solver(0, 0, 0, grid, k, dp);
        if (res == (int) -1e9) return -1;
        return res;
    }
}