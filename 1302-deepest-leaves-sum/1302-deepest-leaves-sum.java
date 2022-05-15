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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> qt=new ArrayDeque<>();
        qt.add(root);
        int ans=0;
        while(qt.size()>0){
            int count=qt.size();
            int temp=0;
            for(int i=0;i<count;i++){
                TreeNode curr=qt.remove();
                temp+=curr.val;
                if(curr.left!=null){
                    qt.add(curr.left);
                }
                if(curr.right!=null){
                    qt.add(curr.right);
                }
                
            }
            ans=temp;
            
        }
        return ans;
    }
}