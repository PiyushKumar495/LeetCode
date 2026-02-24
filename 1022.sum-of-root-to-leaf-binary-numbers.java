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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        call(root,0);
        return sum;
    }
    public void call(TreeNode root, int path){
        if(root==null){
            return;
        }
        path= path*2 + root.val;
        if(root.left==null&& root.right==null){
            sum+=path;            
        }
        call(root.left, path);
        call(root.right,path);
    }
}