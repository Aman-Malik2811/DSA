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
        return util(1,n,new HashMap<Integer, List<TreeNode>>());
    }
    
    private List<TreeNode> util(int l, int r, Map<Integer, List<TreeNode>> dp){
        if(l > r)   return Collections.singletonList(null);
        
        int key = (l<<16) + r;
        if(dp.containsKey(key)) return dp.get(key);
        
        List<TreeNode> ans = new ArrayList<>();
        for(int i=l;i<=r; i++){
            List<TreeNode> leftCombs = util(l,i-1,dp),  rightCombs = util(i+1,r,dp);
            for(TreeNode left: leftCombs){
                for(TreeNode right: rightCombs){
                    TreeNode newComb = new TreeNode(i);
                    newComb.left = left;    newComb.right = right;
                    ans.add(newComb);
                }
            }
        }
        return dp.computeIfAbsent(key, k->ans);
    }
}