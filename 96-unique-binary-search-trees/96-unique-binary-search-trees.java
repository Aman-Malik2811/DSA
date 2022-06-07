class Solution {
    int[][] dp;
    public int numTrees(int n) {
        dp=new int[n+1][n+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        return helper(1,n);
    }
    private int helper(int st,int en){
        if(st>en)return 1;
        if(st==en)return 1;
        int ans=0;
        if(dp[st][en]!=-1)return dp[st][en];
        for(int i=st;i<=en;i++){
            int right=helper(i+1,en);
            int left=helper(st,i-1);
            ans+=(left*right);
        }
        return dp[st][en]=ans;
    }
}