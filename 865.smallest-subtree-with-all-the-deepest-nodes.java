/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    private static class Pair {
        int depth;
        TreeNode node;
        Pair(int d, TreeNode n) {
            depth = d;
            node = n;
        }
    }
    
    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        if (l.depth > r.depth) return new Pair(l.depth + 1, l.node);
        if (r.depth > l.depth) return new Pair(r.depth + 1, r.node);
        return new Pair(l.depth + 1, root);
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}
// @lc code=end

