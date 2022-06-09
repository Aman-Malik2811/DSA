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
    TreeNode fs=null;
    TreeNode ss=null;
    TreeNode itr=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp=fs.val;
        fs.val=ss.val;
        ss.val=temp;
    }
    public void traverse(TreeNode root){
        if(root==null)return;
        traverse(root.left);
        
        if(fs==null&&itr.val>root.val){
            fs=itr;
        }
        if(fs!=null&&itr.val>root.val){
            ss=root;
        }
        
        itr=root;
        traverse(root.right);
    }
}