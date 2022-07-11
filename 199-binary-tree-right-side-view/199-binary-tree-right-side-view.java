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
    private static TreeMap<Integer, Integer> intMap = new TreeMap<Integer, Integer>();
    public void dfs(TreeNode node, int depth) {
        if(node == null) return; 
        intMap.put(depth, node.val);
		
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        intMap.clear(); 
        dfs(root, 0);
        
        return new ArrayList<Integer>(intMap.values());
    }
}