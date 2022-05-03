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
        if(root==null)return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> qt=new ArrayDeque<>();
        qt.add(root);
        while(qt.size()>0){
            int count=qt.size();
            int nextVal=0;
            for(int i=0;i<count;i++){
               TreeNode temp=qt.remove();
               nextVal=temp.val;
                if(temp.left!=null)qt.add(temp.left);
                if(temp.right!=null)qt.add(temp.right);
            }
            ans.add(nextVal);
        }
        return ans;
    }
}