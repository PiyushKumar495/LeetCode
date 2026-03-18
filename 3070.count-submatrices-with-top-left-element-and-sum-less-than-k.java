class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        int[] prefix = new int[m];
        int ans = 0;

        for(int i = 0; i < n; i++){
            int rowSum = 0;
            for(int j = 0; j < m; j++){
                rowSum += grid[i][j];
                prefix[j] += rowSum;

                if(prefix[j] <= k) ans++;
            }
        }
        return ans;
    }
}