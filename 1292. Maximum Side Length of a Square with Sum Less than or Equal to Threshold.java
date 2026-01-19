class Solution {
    private int findSumUtil(int[][] mat, int r1, int c1, int r2, int c2) {
        int m = mat.length, n = mat[0].length, sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++)
                sum += mat[i][j];
        }
        return sum;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int bestSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < Math.min(m - i, n - j); k++) {
                    int i2 = i + k;
                    int j2 = j + k;
                    int val = findSumUtil(mat, i, j, i2, j2);
                    if (val <= threshold)
                        bestSide = Math.max(bestSide, k + 1);
                    else
                        break;
                }
            }
        }
        return bestSide;
    }
}