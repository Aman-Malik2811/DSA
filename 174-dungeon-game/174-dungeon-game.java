class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] d) {
        dp=new int[d.length][d[0].length];
        for(int[] temp:dp)Arrays.fill(temp,-1);
        int ans=helper(d,0,0);
        return ans;
    }
    private int helper(int[][] arr,int i,int j){
        if(i>=arr.length||j>=arr[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==arr.length-1&&j==arr[0].length-1){
            return dp[i][j]=arr[i][j]<0?-1*arr[i][j]+1:1;
        }
       if(dp[i][j]!=-1)return dp[i][j];
        
        int right=helper(arr,i,j+1);
        int down=helper(arr,i+1,j);
        int minHealthforLower=Math.min(right,down);
        if(arr[i][j]>=minHealthforLower)return dp[i][j]=1;
        return dp[i][j]=minHealthforLower-arr[i][j];
    }
}