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
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder=new ArrayList<>();
        helper(inorder,root);
        for(int i=1;i<inorder.size();i++){
            TreeNode curr=inorder.get(i);
            TreeNode prev=inorder.get(i-1);
            if(curr.val>prev.val)continue;
            else{
                int temp=prev.val;
                while(i<inorder.size()&&prev.val>inorder.get(i).val){
                    curr=inorder.get(i++);
                }
                prev.val=curr.val;
                curr.val=temp;
                return;
            }
        }
    }
    private void helper(List<TreeNode> list,TreeNode root){
        if(root==null)return;
        helper(list,root.left);
        list.add(root);
        helper(list,root.right);
    }
}