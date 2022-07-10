class Solution {
    int oneSt=Integer.MAX_VALUE;
    int[] dp;
    public int minCostClimbingStairs(int[] nums) {
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return Math.min(helper(nums,0,nums.length),oneSt);
    }
    private int helper(int[] nums,int i,int n){
        if(i>=n)return 0;
        if(i==n-1){
            if(i==1){
            oneSt=Math.min(nums[i],oneSt);
        }
                   return nums[i];}
        if(dp[i]!=-1)return dp[i];
        int one=helper(nums,i+1,n);
        int two=helper(nums,i+2,n);
        if(i==1){
            oneSt=Math.min(one,two)+nums[i];
        }
        return dp[i]=Math.min(one,two)+nums[i];
    }
}