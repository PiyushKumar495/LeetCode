/*
 * @lc app=leetcode id=1266 lang=java
 *
 * [1266] Minimum Time Visiting All Points
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
          int totalTime = 0;

        for(int i=0; i<points.length-1; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            totalTime += Math.max(dx, dy);
        }
        return totalTime;
    }
}
// @lc code=end

