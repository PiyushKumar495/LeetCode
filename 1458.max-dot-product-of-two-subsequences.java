/*
 * @lc app=leetcode id=1458 lang=java
 *
 * [1458] Max Dot Product of Two Subsequences
 */

// @lc code=start
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solver(nums1,nums2,0,0, dp);
    }

    private int solver(int[] nums1, int[] nums2, int i, int j, int[][] dp){
        if(i==nums1.length || j==nums2.length){
            return Integer.MIN_VALUE/2;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int a = nums1[i]*nums2[j];
        int next = solver(nums1,nums2,i+1,j+1, dp);
        a = Math.max(a,a+next);
        int b = solver(nums1,nums2,i,j+1, dp);
        int c = solver(nums1,nums2,i+1,j, dp);

        return dp[i][j] = Math.max(a,Math.max(b,c));
    }
}
// @lc code=end

