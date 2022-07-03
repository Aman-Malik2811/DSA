class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp=new int[nums.length][2];
        dp[0][0]=1;
        dp[0][1]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i][0]=dp[i-1][1]+1;
                dp[i][1]=dp[i-1][1];
            }
            else if(nums[i]<nums[i-1]){
                dp[i][1]=dp[i-1][0]+1;
                dp[i][0]=dp[i-1][0];
            }
            else{
                dp[i][1]=dp[i-1][1];
                dp[i][0]=dp[i-1][0];
            }
        }
        int n=nums.length;
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}