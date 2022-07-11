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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        helper(ans,root,1);
        return ans;
    }
    private void helper(List<Integer> ans,TreeNode root,int ht){
        if(root==null)return;
        if(ans.size()<ht){
            ans.add(root.val);
        }
        else{
            ans.set(ht-1,root.val);
        }
        helper(ans,root.left,ht+1);
        helper(ans,root.right,ht+1);
    }
}