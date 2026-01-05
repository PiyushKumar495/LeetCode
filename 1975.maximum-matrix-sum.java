/*
 * @lc app=leetcode id=1975 lang=java
 *
 * [1975] Maximum Matrix Sum
 */

// @lc code=start
class Solution {
    public long maxMatrixSum(int[][] matrix) {
          long sum = 0;
        int mn = Integer.MAX_VALUE;
        int negCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];
                sum += Math.abs(val);
                if (val < 0) negCount++;
                mn = Math.min(mn, Math.abs(val));
            }
        }

        return (negCount % 2 == 0) ? sum : sum - 2L * mn;
    }
}
// @lc code=end

