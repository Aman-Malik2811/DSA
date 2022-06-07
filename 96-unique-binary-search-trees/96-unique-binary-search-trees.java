class Solution {
    int[][] dp;
    public int numTrees(int n) {
         int [] G = new int[n+1];
  G[0] = G[1] = 1;
    
  for(int i=2; i<=n; ++i) {
    for(int j=1; j<=i; ++j) {
      G[i] += G[j-1] * G[i-j];
    }
  }
  return G[n];
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