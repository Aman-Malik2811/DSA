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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<>();
        LinkedList<Integer> ans=new LinkedList<>();
        Stack<TreeNode> st=new Stack<>();
        st.add(root);
        while(st.size()>0){
             TreeNode curr=st.pop();
             ans.addFirst(curr.val);
            if(curr.left!=null){
                st.push(curr.left);
            }if(curr.right!=null){
                 st.push(curr.right);
             }
        }
        
        return ans;
    }
}