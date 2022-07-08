class Solution {
    int ans=1000001;
    Integer[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp=new Integer[m+1][target+1][n+1];
        int temp=helper(0,cost,m,n,target,0,0,houses);
        return temp==ans?-1:temp;
    }
    private int helper(int i,int[][] cost,int m,int n,int target,int nbr,int prev,int[] houses){
        if(i==m){
            if(target==nbr)return 0;
            return ans;
        }
        if(nbr>target)return ans;
        if(dp[i][nbr][prev]!=null)return dp[i][nbr][prev];
        int minCost=ans;
        if(houses[i]!=0){
            int newnbr=nbr+(houses[i]!=prev?1:0);
            minCost=helper(i+1,cost,m,n,target,newnbr,houses[i],houses); 
        }
        else{
           for(int j=0;j<n;j++){
               int newnbr=nbr+((j+1)!=prev?1:0);
               int temp=cost[i][j]+helper(i+1,cost,m,n,target,newnbr,j+1,houses);
               minCost=Math.min(minCost,temp);
           } 
        }
        return dp[i][nbr][prev]=minCost;
       
    }
    
}