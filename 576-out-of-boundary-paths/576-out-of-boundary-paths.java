class Solution {
//     public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//         int[][] dp=new int[m][n];
//         dp[0][0]=dp[m-1][n-1]=dp[0][m-1]=dp[n-1][0]=2;
//         for(int i=1;i<n-1;i++){
//             dp[0][i]=1;
//             dp[m-1][i]=1;
//         }
//         for(int i=1;i<m-1;i++){
//             dp[i][0]=1;
//             dp[i][n-1]=1;
//         }
//         for(int i=1;i<m-1;i++){
//             for(int j=1;j<n-1;j++){
                
//             }
//         }
//     }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[m][n][maxMove+1];
        return helper(m,n,startRow,startColumn,maxMove,maxMove);
    }
    Integer[][][] dp;
    int mod = 1000000007;
    public int helper(int m,int n,int i,int j,int mov,int max){
         if(i<0||j<0||i>=m||j>=n)return 1;
         if(mov<=0)return 0;
         if(dp[i][j][mov]!=null)return dp[i][j][mov];
         int count=0;
         count=count%mod+helper(m,n,i-1,j,mov-1,max)%mod;
         count=count%mod+helper(m,n,i+1,j,mov-1,max)%mod;
         count=count%mod+helper(m,n,i,j+1,mov-1,max)%mod;
         count=count%mod+helper(m,n,i,j-1,mov-1,max)%mod;
         dp[i][j][mov]=count%mod;
        return dp[i][j][mov];
    }
}