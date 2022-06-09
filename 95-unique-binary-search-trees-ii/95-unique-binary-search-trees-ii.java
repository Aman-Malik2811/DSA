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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    private List<TreeNode> helper(int st,int en){
        if(st>en){
            List<TreeNode> ans=new ArrayList<>();
            ans.add(new TreeNode(-1));
            return ans;
        }
        if(st==en){
            List<TreeNode> ans=new ArrayList<>();
            ans.add(new TreeNode(st));
            return ans;
        }
        List<TreeNode> ans=new ArrayList<>();
        for(int i=st;i<=en;i++){
            List<TreeNode> left=helper(st,i-1);
            List<TreeNode> right=helper(i+1,en);
            for(TreeNode lef:left){
                for(TreeNode rig:right){
                    TreeNode curr=new TreeNode(i);
                    curr.left=lef.val==-1?null:lef;
                    curr.right=rig.val==-1?null:rig;
                     ans.add(curr);
                }
               
            }
        }
        return ans;
    }
}