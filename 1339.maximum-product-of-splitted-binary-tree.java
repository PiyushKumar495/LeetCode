/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     long res = 0;
    public int maxProduct(TreeNode root) {
        long sum = getSum(root);
        getRes(root, sum);
        return (int)(res % ((int)1e9 + 7));
    }

    public long getRes(TreeNode node, long sum){
        if(node == null){
            return 0;
        }
        long curr = node.val + getRes(node.left, sum) + getRes(node.right, sum);
        res = Math.max(res, (sum - curr) * curr);
        return curr;
    }

    public long getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);
    }
}
// @lc code=end

